package test.lind.javaLindDay.exception;

import org.springframework.http.HttpStatus;

/**
 * NotAcceptable406的异常.
 */
public class NotAcceptableException extends StatusCodeException {


  /**
   * 构造函数.
   *
   * @param message 异常消息.
   * @param data    附加信息.
   */
  public NotAcceptableException(String message, Object data) {
    super(HttpStatus.NOT_ACCEPTABLE, message, data);
  }
}
