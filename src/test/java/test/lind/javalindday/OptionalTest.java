package test.lind.javalindday;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;
import test.lind.javalindday.model.UserInfo;

public class OptionalTest {
  List<UserInfo> list = ImmutableList.of(
      UserInfo.builder().name("zzl").build(),
      UserInfo.builder().name("zhz").build());

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
}
