package test.lind.javaLindDay.exception;

import org.springframework.http.HttpStatus;

/**
 * 资源先决条件不正确的异常.
 */
public class PreconditionFailedException extends StatusCodeException {

  /**
   * 构造函数.
   *
   * @param message 异常消息.
   */
  public PreconditionFailedException(String message) {
    super(HttpStatus.PRECONDITION_FAILED, message, null);
  }
}
