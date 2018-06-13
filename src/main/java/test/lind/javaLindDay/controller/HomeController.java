package test.lind.javaLindDay.controller;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.lind.javaLindDay.classDemo.AodiCar;
import test.lind.javaLindDay.classDemo.Car;
import test.lind.javaLindDay.model.OrderInfo;
import test.lind.javaLindDay.mongodbDemo.InsertDemo;
import test.lind.javaLindDay.utilDemo.MyConfig;

@Slf4j
@RestController
public class HomeController {

  @Autowired
  MyConfig config;

  @Autowired
  InsertDemo insertDemo;
  @Autowired
  MongoTemplate mongoTemplate;

  @RequestMapping("/")
  public Map<String, String> Index(@PathVariable String buyer) throws Exception {
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

