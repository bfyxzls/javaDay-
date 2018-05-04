package test.lind.javaLindDay.classDemo;

import org.springframework.stereotype.Service;

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
