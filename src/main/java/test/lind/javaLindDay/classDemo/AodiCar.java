package test.lind.javaLindDay.classDemo;

public class AodiCar extends Car {

  protected boolean selfValidate() {
    System.out.println("Aodi");
    if (super.getDischarge() < 95) {
      return false;
    } else {
      return true;
    }
  }
}
