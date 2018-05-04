package test.lind.javaLindDay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.lind.javaLindDay.classDemo.AodiCar;
import test.lind.javaLindDay.classDemo.Car;
import test.lind.javaLindDay.utilDemo.MyConfig;

@RestController
public class HomeController {

  @Autowired
  MyConfig config;

  @Value("${lind.name}")
  String app;

  @RequestMapping("/")
  public String Index() throws Exception {

    Car car = (Car) Class.forName(AodiCar.class.getName()).newInstance();

    car.validate();
    return "HOME=" + config.getName() + "app=" + app;
  }
}
