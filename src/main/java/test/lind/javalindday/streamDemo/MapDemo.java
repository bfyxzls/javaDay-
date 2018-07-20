package test.lind.javalindday.streamDemo;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    maps = maps.stream().distinct().collect(toList());
    System.out.println(maps);
  }

  public static void testMap() {
    double val = 114;
    List<Integer> integers = new ArrayList<>();
    //添加数据略
    integers.add(1);
    integers.add(10);
    integers.add(100);
    System.out.println("stream map demo");
    integers.stream().map(i -> i + 1).collect(toList()).forEach(System.out::println);
  }

  public static void testMapToMap() {
    List<List<Integer>> outer = new ArrayList<>();
    List<Integer> inner1 = new ArrayList<>();
    inner1.add(1);
    List<Integer> inner2 = new ArrayList<>();
    inner1.add(2);
    List<Integer> inner3 = new ArrayList<>();
    inner1.add(3);
    List<Integer> inner4 = new ArrayList<>();
    inner1.add(4);
    List<Integer> inner5 = new ArrayList<>();
    inner1.add(5);
    outer.add(inner1);
    outer.add(inner2);
    outer.add(inner3);
    outer.add(inner4);
    outer.add(inner5);
    List<Integer> result = outer.stream().flatMap(inner -> inner.stream().map(i -> i + 1)).collect(toList());
    System.out.println(result);
  }

  public static void baiduTest() {
    List<BaiduShop> baiduShops = new ArrayList<>();
    BaiduShop baiduShop = new BaiduShop();
    baiduShop.setName("ok");
    baiduShops.add(baiduShop);
    baiduShop.setName("good");//它会把上面的ok覆盖,必须从新定义新的变量
    baiduShops.add(baiduShop);
    baiduShops.stream().map(o -> o.getName()).forEach(System.out::println);


  }
}

class BaiduShop extends HashMap<String, Object> {
  private String name;

  public String getName() {

    return this.get("name").toString();
  }

  public void setName(String name) {
    this.put("name", name);
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