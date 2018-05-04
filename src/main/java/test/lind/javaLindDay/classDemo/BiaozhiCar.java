package test.lind.javaLindDay.classDemo;

public class BiaozhiCar extends Car {
  protected boolean selfValidate() {
    System.out.println("Biaozhi");
    if (super.getDischarge() < 92) {
      return false;
    } else {
      return true;
    }
  }
}
