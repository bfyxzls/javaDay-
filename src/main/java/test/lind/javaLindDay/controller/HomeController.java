package test.lind.javaLindDay.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.lind.javaLindDay.classDemo.AodiCar;
import test.lind.javaLindDay.classDemo.Car;
import test.lind.javaLindDay.model.UserInfo;
import test.lind.javaLindDay.utilDemo.MyConfig;

@RestController
public class HomeController {

  @Autowired
  MyConfig config;


  @RequestMapping("/")
  public String Index() throws Exception {

    Car car = (Car) Class.forName(AodiCar.class.getName()).newInstance();

    car.validate();
    return "HOME";
  }

  @PostMapping("/add")
  public String index(@Valid @RequestBody UserInfo userInfo) {
    return "post";
  }
}

