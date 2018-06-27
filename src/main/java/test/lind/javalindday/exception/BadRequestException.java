package test.lind.javalindday.exception;

import org.springframework.http.HttpStatus;

/**
 * 客户端请求错误的异常.
 */
public class BadRequestException extends StatusCodeException {

  /**
   * 构造函数.
   *
   * @param message 异常消息.
   */
  public BadRequestException(String message) {
    super(HttpStatus.BAD_REQUEST, message, null);
  }

  /**
   * 返回异常消息.
   * @param message 消息.
   * @param obj 错误消息列表.
   */
  public BadRequestException(String message,Object obj) {
    super(HttpStatus.BAD_REQUEST, message, obj);
  }
}
