package test.lind.javaLindDay.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionDemo {

  public void sortList() {
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
    Collections.sort(names2, (String a, String b) -> {
      return b.compareTo(a);
    });
    Collections.sort(names2, (a, b) -> b.compareTo(a));
    for (String name : names2
        ) {
      System.out.println(name);
    }
  }
}
