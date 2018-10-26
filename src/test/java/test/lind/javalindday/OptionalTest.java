package test.lind.javalindday;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.javamoney.moneta.Money;
import org.junit.Assert;
import org.junit.Test;
import test.lind.javalindday.model.UserInfo;

public class OptionalTest {
  List<UserInfo> list = ImmutableList.of(
      UserInfo.builder().name("zzl").email("zzl@sina.com").price(Money.of(100, "CNY")).age(35).build(),
      UserInfo.builder().name("zhz").email("zhz@sina.com").price(Money.of(200, "CNY")).age(40).build());

  @Test
  public void findFirst() {
    UserInfo result = list.stream()
        .filter(o -> o.getName().equals("zzl"))
        .findFirst()
        .orElse(null);
  }

  @Test
  public void toList() {
    List<String> nameList = list.stream()
        .filter(o -> o.getName().contains("b"))
        .map(o -> o.getName())
        .collect(Collectors.toList());

    Assert.assertEquals(0, nameList.size());
  }

  @Test
  public void ifPresent() {
    Optional<Integer> a = Optional.ofNullable(1);
    a.ifPresent(o -> Assert.assertEquals(1, 1));
  }

  @Test
  public void map() {
    Optional<Integer> opt = Optional.ofNullable(1);
    opt.map(o -> {
      System.out.println("1 while opt is present...");//do it
      return 1;
    }).orElseGet(() -> {
      System.out.println("1 create new obj");
      return null;
    });

    Optional<Integer> optNull = Optional.ofNullable(null);
    optNull.map(o -> {
      System.out.println("2 while opt is present...");
      return 1;
    }).orElseGet(() -> {
      System.out.println("2 create new obj");//do it
      return null;
    });
  }

  /**
   * ImmutableMap.of里面的value不能是object类型，即它是一个确定的类型.
   */
  @Test
  public void listToMap1() {
    List<Map<String, String>> maps = list.stream()
        .map(o ->
            ImmutableMap.of("Email", o.getEmail(), "price", "2"))
        .collect(Collectors.toList());
  }


  /**
   * ImmutableMap.Builder<String, Object>()可以赋Map<String,Object>的对象，但value为能为null.
   */
  @Test
  public void listToMap3() {
    List<Map<String, Object>> maps = list.stream()
        .map(o ->
            new ImmutableMap.Builder<String, Object>()
                .put("name", o.getName())
                .put("email", o.getEmail())
                .put("price", o.getPrice())
                .build())
        .collect(Collectors.toList());
    maps.forEach(System.out::println);
  }

  @Test
  public void reduce() {
    int result = list.stream().map(o -> o.getAge()).reduce((a, b) -> (a + b)).orElse(0);
    Assert.assertEquals(75, result);
  }
}
