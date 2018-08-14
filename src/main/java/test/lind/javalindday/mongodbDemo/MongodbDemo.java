package test.lind.javalindday.mongodbDemo;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import test.lind.javalindday.model.OrderInfo;
import test.lind.javalindday.model.Test;

@Service
public class MongodbDemo {
  @Autowired
  MongoOperations mongoTemplate;

  public void test() {
    Map<String, Map<String, Object>> lines = new HashMap<>();
    Map<String, Object> maps = new HashMap<>();
    maps.put("Info", "手机");
    maps.put("Price", "180");
    maps.put("AtTime", "2018-1-1");
    lines.put("01", maps);
    maps.clear();
    maps.put("Info", "手表");
    maps.put("Price", "380");
    maps.put("AtTime", "2018-11-1");
    lines.put("02", maps);

    OrderInfo orderInfo = OrderInfo.builder()
        .buyer("zzl")
        .totalPrice(BigDecimal.valueOf(20))
        .history(lines)
        .build();

    mongoTemplate.insert(orderInfo);
  }

  public List<OrderInfo> get() {
    Criteria cri = where("history.01.Info").is("手表");
    Query query = Query.query(cri);

    return mongoTemplate.find(query, OrderInfo.class);
  }

  /**
   * 返回员工校验的mapFunction.
   */
  private String getMap(String username, String age) {
    try {
      InputStream file = this.getClass().getResourceAsStream("/employee_idNumber_idType_Map.js");
      int temp = 0;
      StringBuilder stringBuilder = new StringBuilder();
      while ((temp = file.read()) != -1) {
        stringBuilder.append((char) temp);
      }
      file.close();
      String map = stringBuilder.toString();
      map = map.replaceAll("@@username", username)
          .replaceAll("@@age", age);
      return map;
    } catch (IOException io) {
      return null;
    }
  }

  public void mapreduce() {
    MapReduceOptions options = new MapReduceOptions();
    options.outputTypeInline();
    String map = getMap("zzl", "10");
    MapReduceResults<Map> results = mongoTemplate.mapReduce(
        "test",
        map,
        "classpath:reduce.js",
        options,
        Map.class
    );

    results.forEach(System.out::println);


    System.out.println("collection size:" + mongoTemplate.findAll(Test.class).size());

    System.out.println("map reduce count:" + results.iterator().hasNext());
  }
}
