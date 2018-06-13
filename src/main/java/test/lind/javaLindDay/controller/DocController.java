package test.lind.javaLindDay.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import test.lind.javaLindDay.classDemo.AodiCar;
import test.lind.javaLindDay.classDemo.Car;

@RestController
public class DocController {
  public static final String DOC = "/doc/{buyer}";

  @GetMapping(DOC)
  public Map<String, String> index(@PathVariable String buyer) throws Exception {
    Car car = (Car) Class.forName(AodiCar.class.getName()).newInstance();
    car.validate();
    Map<String, String> maps = new HashMap<>();
    maps.put("name", "Hello");
    maps.put("sex", "1");
    maps.put("buyer", buyer);
    return maps;
  }
}
