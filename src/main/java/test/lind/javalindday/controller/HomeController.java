package test.lind.javalindday.controller;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.lind.javalindday.classDemo.AodiCar;
import test.lind.javalindday.classDemo.Car;
import test.lind.javalindday.model.OrderInfo;
import test.lind.javalindday.model.Person;
import test.lind.javalindday.mongodbDemo.MongodbDemo;
import test.lind.javalindday.utilDemo.MyConfig;

@Slf4j
@RestController
public class HomeController {

  @Autowired
  MyConfig config;

  @Autowired
  MongodbDemo insertDemo;
  @Autowired
  MongoTemplate mongoTemplate;

  @RequestMapping("/")
  public Map<String, String> Index(@RequestParam String buyer) throws Exception {
    insertDemo.add();
    List<Person> list = new ArrayList<>();
    list.add(new Person(1, "zzl", new Date(), Person.Gender.MALE));
    log.debug("person:{}", list.toString());
    Car car = (Car) Class.forName(AodiCar.class.getName()).newInstance();
    car.validate();
    Map<String, String> maps = new HashMap<>();
    maps.put("name", "Hello");
    maps.put("sex", "1");
    maps.put("buyer", buyer);
    log.info("userinfo:{}", maps);
    return maps;
  }

  @GetMapping("/add")
  public String add() {
    insertDemo.test();
    return config.getName();
  }

  @GetMapping("/map-reduce")
  public void mapReduce() {
    insertDemo.mapreduce();
  }

  @GetMapping("/errors")
  public String errors() {
    int a = 0;
    int b = 1 / a;
    return "OK";
  }

  @GetMapping("/edit")
  public OrderInfo edit() {
    Criteria cri = where("id").is("5b0e665d9015deea03996a0c");
    Query query = Query.query(cri);
    Update update = new Update();
    update.set("history.01.Info", "tel");
    return mongoTemplate.findAndModify(query, update, OrderInfo.class);
  }
}

