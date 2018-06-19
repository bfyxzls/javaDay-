package test.lind.javaLindDay.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


/**
 * 状态码异常.
 */
public abstract class StatusCodeException extends RuntimeException {


  /**
   * 状态码.
   */
  @Getter
  private HttpStatus httpStatus;


  /**
   * 附加数据.
   */
  @Getter
  private Object data;

  /**
   * 构造函数.
   *
   * @param httpStatus 状态码.
   * @param message    异常消息.
   * @param data       附加数据.
   */
  public StatusCodeException(HttpStatus httpStatus,
                             String message,
                             Object data) {
    super(message);
    this.httpStatus = httpStatus;
    this.data = data;
  }
}
