package test.lind.javaLindDay.classDemo;

public class BiaozhiCar extends Car {
  @Override
  public void printName() {
    super.printName();
    System.out.println("标志");
  }

  protected boolean selfValidate() {
    System.out.println("Biaozhi");
    if (super.getDischarge() < 92) {
      return false;
    } else {
      return true;
    }
  }
}
