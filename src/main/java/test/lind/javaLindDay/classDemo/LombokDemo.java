package test.lind.javaLindDay.classDemo;

import test.lind.javaLindDay.model.UserInfo;


public class LombokDemo {
  public void test() {
    UserInfo userInfo = UserInfo.builder()
        .name("zzl")
        .email("bgood@sina.com")
        .build();
    userInfo = userInfo.toBuilder()
        .name("OK")
        .email("zgood@sina.com")
        .build();
    System.out.println("name=" + userInfo.getName());
  }

}
