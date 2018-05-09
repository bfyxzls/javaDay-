package test.lind.javaLindDay.collectionDemo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * stream里的聚合计算.
 */
public class StreamDemo {
  public void test() {
    List<BigDecimal> list = new ArrayList<>();
    list.add(BigDecimal.valueOf(1));
    list.add(BigDecimal.valueOf(3));
    list.add(BigDecimal.valueOf(5));
    BigDecimal accResult = list.stream()
        .reduce(BigDecimal.valueOf(0), (acc, item) -> {
          System.out.println("acc : " + acc);
          acc = acc.add(item);
          System.out.println("item: " + item);
          System.out.println("acc+ : " + acc);
          System.out.println("--------");
          return acc;
        });
    System.out.println(String.format("accResult=%f", accResult));

    List<Temp> tempList = new ArrayList<>();
    tempList.add(new Temp("zzl", 9));
    tempList.add(new Temp("lr", 19));
    tempList.add(new Temp("zhz", 1));
    int result = tempList.stream()
        .map(i -> i.score)
        .reduce(0, (acc, item) -> {
          acc += item;
          return acc;
        });
    System.out.println(String.format("tempList=%d", result));

  }

  @Data
  @AllArgsConstructor
  class Temp {
    private String name;
    private int score;
  }
}
