package test.lind.javalindday;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

public class QuickInitTest {
  @Test
  public void list() {
    List<Integer> list = Arrays.asList(1, 2, 3);
  }

  @Test
  public void map() {
    Map<String, Boolean> map = ImmutableMap.of("message", false);

  }

  @Test
  public void array() {
    int[] arr = new int[] {1, 2, 3};
  }

  @Test
  public void set() {
    Set<Integer> set = ImmutableSet.of(1, 2, 3);
  }
}
