package test.lind.javalindday.classDemo;

import test.lind.javalindday.model.UserInfo;


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
