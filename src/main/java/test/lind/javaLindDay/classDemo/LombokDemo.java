package test.lind.javaLindDay.classDemo;


import lombok.Value;
import lombok.val;

import java.util.Date;


public class LombokDemo {
  public void test() {
    val model = new model("zzl", new Date());
    System.out.println(model.getName());


  }

  @Value
  public class model {
    private String name;
    private Date createAt;

  }
}
