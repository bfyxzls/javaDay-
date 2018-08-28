package test.lind.javalindday;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;
import test.lind.javalindday.model.UserInfo;

public class OptionalTest {
  @Test
  public void findFirst() {
    List<UserInfo> list = ImmutableList.of(
        UserInfo.builder().name("zzl").build(),
        UserInfo.builder().name("zhz").build());

    UserInfo result = list.stream()
        .filter(o -> o.getName().equals("zzl"))
        .findFirst()
        .orElse(null);
  }

  @Test
  public void toList() {
    List<UserInfo> list = ImmutableList.of(
        UserInfo.builder().name("zzl").build(),
        UserInfo.builder().name("zhz").build());

    List<String> nameList = list.stream()
        .filter(o -> o.getName().contains("b"))
        .map(o -> o.getName())
        .collect(Collectors.toList());

    Assert.assertEquals(0, nameList.size());
  }
}
