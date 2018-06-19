package test.lind.javaLindDay.exception;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 错误处理.
 */
@Slf4j
@ControllerAdvice
public class ErrorHandler {

  /**
   * 处理Exception异常.
   *
   * @param exception 异常.
   * @return 错误消息.
   */
  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public ResponseEntity<Error> handlerException(
      Exception exception,
      HttpServletRequest request) {

    ResponseEntity<Error> response;

    if (exception instanceof HttpMessageNotReadableException) {
      response = buildResponseFromHttpMessageNotReadableException(
          (HttpMessageNotReadableException) exception,
          request
      );

      log.info("无法读取客户端请求{}", response.getBody());
      return response;
    }

    if (exception instanceof MethodArgumentNotValidException) {
      response = buildResponseFromMethodArgumentNotValidException(
          (MethodArgumentNotValidException) exception,
          request
      );

      log.info("客户端请求参数错误{}", response.getBody());
      return response;
    }

    if (exception instanceof MethodArgumentTypeMismatchException) {
      response = buildMethodArgumentTypeMismatchException(
          (MethodArgumentTypeMismatchException) exception,
          request
      );

      log.info("客户端请求参数错误{}", response.getBody());
      return response;
    }

    if (exception instanceof StatusCodeException) {
      response = buildResponseFromStatusCodeException(
          (StatusCodeException) exception,
          request
      );

      log.info("处理的请求异常{}", response.getBody());
      return response;
    }

    if (exception instanceof ConstraintViolationException) {
      response = buildResponseFromConstriaintViolationExceptionn(request,
          (ConstraintViolationException) exception);
      return response;
    }

    response = buildResponseFromException(
        exception,
        request
    );

    log.info("未知的错误", exception);
    return response;
  }

  private ResponseEntity<Error> buildResponseFromConstriaintViolationExceptionn(
      HttpServletRequest request,
      ConstraintViolationException exception1) {
    Error error = initErrorFromRequest(request);
    error.status = HttpStatus.BAD_REQUEST;
    for (ConstraintViolation<?> violation :
        exception1.getConstraintViolations()) {
      String name = violation.getPropertyPath().toString();
      if (StringUtils.isNotBlank(name)) {
        int index = name.indexOf(".");
        if (index >= 0 && name.length() >= index + 1) {
          name = name.substring(index + 1);
        }
      }
      String message = violation.getMessageTemplate();
      error.add(name, message);
    }
    return new ResponseEntity<>(error, error.status);
  }

  private ResponseEntity<Error> buildResponseFromHttpMessageNotReadableException(
      HttpMessageNotReadableException exception,
      HttpServletRequest request) {

    Error error = initErrorFromRequest(request);
    error.status = HttpStatus.BAD_REQUEST;
    error.add(exception.getMessage());

    return new ResponseEntity<>(error, error.status);
  }

  private ResponseEntity<Error> buildMethodArgumentTypeMismatchException(
      MethodArgumentTypeMismatchException exception,
      HttpServletRequest request) {

    Error error = initErrorFromRequest(request);
    error.status = HttpStatus.BAD_REQUEST;

    Object value = exception.getValue();
    Class<?> requiredType = exception.getRequiredType();
    if (value != null && requiredType != null) {
      String message = String.format("'%s'不是有效的'%s'类型",value.toString(),requiredType.getName());
      error.add(exception.getName(),message);
    }
    return new ResponseEntity<>(error, error.status);
  }

  private ResponseEntity<Error> buildResponseFromMethodArgumentNotValidException(
      MethodArgumentNotValidException exception,
      HttpServletRequest request) {

    Error error = initErrorFromRequest(request);
    error.status = HttpStatus.BAD_REQUEST;

    BindingResult bindingResult = exception.getBindingResult();
    for (ObjectError bindError : bindingResult.getAllErrors()) {
      String name = bindError.getObjectName();
      String message = bindError.getDefaultMessage();
      if (bindError instanceof FieldError) {
        name = ((FieldError) bindError).getField();
      }
      error.add(name, message);
    }

    return new ResponseEntity<>(error, error.status);
  }

  private ResponseEntity<Error> buildResponseFromStatusCodeException(
      StatusCodeException exception,
      HttpServletRequest request) {

    Error error = initErrorFromRequest(request);
    error.status = exception.getHttpStatus();
    error.data = exception.getData();
    error.add(exception.getMessage());

    return new ResponseEntity<>(error, error.status);
  }

  private ResponseEntity<Error> buildResponseFromException(
      Exception exception,
      HttpServletRequest request) {

    Error error = initErrorFromRequest(request);
    error.status = HttpStatus.INTERNAL_SERVER_ERROR;
    error.add(exception.getMessage());

    return new ResponseEntity<>(error, error.status);
  }

  private Error initErrorFromRequest(HttpServletRequest request) {

    Error error = new Error();
    error.method = request.getMethod();
    error.path = request.getRequestURI();

    return error;
  }

  @ToString
  private static class Error {

    public String method;

    public String path;

    public HttpStatus status;

    public Object data;

    @Getter
    private List<Item> errors = new ArrayList<>();

    public void add(String error, String message) {
      Item errorItem = new Item();
      errorItem.error = error;
      errorItem.message = message;
      this.errors.add(errorItem);
    }

    public void add(String message) {
      this.add(this.status.name(), message);
    }

    @ToString
    private static class Item {

      public String error;

      public String message;
    }
  }
}
