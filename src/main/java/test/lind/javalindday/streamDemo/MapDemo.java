package test.lind.javalindday.streamDemo;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

public class MapDemo {
  public static void test() {
    List<Order> orderList = new ArrayList<>();

    Order order = Order.builder()
        .buyer(Buyer.builder().age(70).build())
        .seller(Seller.builder().name("zzl").build())
        .build();
    orderList.add(order);
    orderList.stream()
        .filter(t -> t.getBuyer().getAge() >= 65)
        .map(Order::getSeller)
        .distinct()
        .sorted(comparing(Seller::getName))
        .map(Seller::getName)
        .forEach(System.out::println);
  }

  public static void testDistinct() {
    List<Map<String, Object>> maps = new ArrayList<>();
    Map<String, Object> obj = new HashMap<>();
    obj.put("name", "one");
    obj.put("age", 1);
    maps.add(obj);
    obj = new HashMap<>();
    obj.put("name", "one");
    obj.put("age", 1);
    maps.add(obj);
    obj = new HashMap<>();
    obj.put("name", "one");
    obj.put("age", 1);
    maps.add(obj);
    maps = maps.stream().distinct().collect(Collectors.toList());
    System.out.println(maps);
  }
}

@Builder
@Value
class Seller {
  private int age;
  private String name;
}

@Builder
@Getter
class Buyer {
  private int age;
  private String name;
}

@Builder
@Getter
class Order {
  private Buyer buyer;
  private Seller seller;
}