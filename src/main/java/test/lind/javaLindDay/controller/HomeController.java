package test.lind.javaLindDay.controller;

import javax.validation.Valid;
import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zalando.jackson.datatype.money.MoneyModule;
import test.lind.javaLindDay.classDemo.AodiCar;
import test.lind.javaLindDay.classDemo.Car;
import test.lind.javaLindDay.model.UserInfo;
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

  @PostMapping("/add")
  public String index(@Valid @RequestBody UserInfo userInfo) {
    return "post";
  }
}

