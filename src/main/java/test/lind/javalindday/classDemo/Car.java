package test.lind.javalindday.classDemo;

import lombok.Data;

@Data
public abstract class Car {
  private int discharge;

  public void validate() {
    if (selfValidate()) {
      System.out.println("验证成功");
    } else {
      System.out.println("验证失败");
    }
  }

  public void printName() {
    System.out.println("汽车");
  }

  protected boolean selfValidate() {
    return true;
  }
}
