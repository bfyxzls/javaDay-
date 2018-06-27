package test.lind.javalindday.streamDemo;

import java.util.ArrayList;
import static java.util.Comparator.comparing;
import java.util.List;
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