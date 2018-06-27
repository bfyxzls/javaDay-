package test.lind.javalindday.collectionDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.Value;
import lombok.val;

public class CollectionDemo {

  /**
   * sort list.
   */
  public void sortList() {
    int[] arInt = {1, 2, 3, 4, 5};
    String[] arStr = {"one", "two", "three"};
    List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
    Collections.sort(names, new Comparator<String>() {
      @Override
      public int compare(String a, String b) {
        return b.compareTo(a);
      }
    });
    for (String name : names
        ) {
      System.out.println(name);
    }

    //java8 lambda
    List<String> names2 = Arrays.asList("a", "c", "d", "b");
    Collections.sort(names2, (String a, String b) -> b.compareTo(a));
    Collections.sort(names2, (a, b) -> b.compareTo(a));
    for (String name : names2
        ) {
      System.out.println(name);
    }
  }

  /**
   * lambda filter not.
   *
   * @param subjects
   * @param predicate
   * @return
   */
  private List<User> conditionFilterNot(List<User> subjects, Predicate<User> predicate) {

    return subjects.stream().filter(predicate.negate()).collect(Collectors.toList());
  }

  /**
   * lambda filter.
   *
   * @param list
   * @param predicate
   * @return
   */
  public List<User> conditionFilter(List<User> list, Predicate<User> predicate) {
    return list.stream().filter(predicate).collect(Collectors.toList());
  }

  /**
   * find list.
   */
  public void findList() {
    List<User> list = new ArrayList<>();
    list.add(new User("zzl"));
    list.add(new User("abc"));
    list.add(new User("bca"));
    val listResult1 = conditionFilter(list, exe -> exe.getName() == "zzl");
    for (User user : listResult1
        ) {
      System.out.println(user.getName());

    }

    val listResult = list.stream().filter(o -> o.name != "zzl").collect(Collectors.toList());

    for (User item : listResult
        ) {
      System.out.println(item.getName());
    }
  }

  @Value
  class User {
    private String name;
  }
}
