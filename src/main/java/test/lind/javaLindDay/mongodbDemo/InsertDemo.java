package test.lind.javaLindDay.mongodbDemo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import test.lind.javaLindDay.model.OrderInfo;

@Service
public class InsertDemo {
  @Autowired
  MongoTemplate mongoTemplate;

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
}
