package test.lind.javaLindDay.utilDemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class ConfigDemo {
  @Value("${lind.name}")
  private String name;

  @Autowired
  private MyConfig myConfig;


  public void test() {
    System.out.println("config.name=" + name);
    System.out.println("myConfig.name=" + myConfig.getName());

  }
}
