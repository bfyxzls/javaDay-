package test.lind.javaLindDay.utilDemo;

import lombok.extern.slf4j.Slf4j;
import test.lind.javaLindDay.model.UserInfo;

@Slf4j
public class LoggerDemo {
  public void test() {
    UserInfo userInfo = UserInfo.builder().name("zzl").email("zzl@sina.com").build();
    log.debug("{} format print {}", "hello", userInfo);
  }
}
