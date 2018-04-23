package test.lind.javaLindDay.classDemo;


import lombok.Value;
import lombok.val;

import java.util.Date;

@Value
class model {
  private String name;
  private Date createAt;

}

public class lombokDemo {
  public void test() {
    val model = new model("zzl", new Date());
    System.out.println(model.getName());


  }
}
