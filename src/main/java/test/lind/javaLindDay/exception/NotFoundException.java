package test.lind.javaLindDay.exception;

import org.springframework.http.HttpStatus;

/**
 * 资源没有找到的异常.
 */
public class NotFoundException extends StatusCodeException {

  /**
   * 构造函数.
   *
   * @param message 异常消息.
   */
  public NotFoundException(String message) {
    super(HttpStatus.NOT_FOUND, message, null);
  }
}
