package test.lind.javalindday.generic;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class GenericFunDemo {

  public static <K, V> Map<K, V> singletonMap(Function<V, K> key, V value) {
    return Collections.singletonMap(key.apply(value), value);
  }

  public static <K, V> Map<K, V> ofEmpty(Map<K, V> map) {
    return Optional.ofNullable(map).orElse(Collections.emptyMap());
  }

  /**
   * java8几表函数式接口.
   */
  public static void testFun() {
    // Function<T, R> -T作为输入，返回的R作为输出
    Function<String, String> function = (x) -> {
      System.out.print(x + ": ");
      return "Function";
    };
    System.out.println(function.apply("hello world"));

    //Predicate<T> -T作为输入，返回的boolean值作为输出
    Predicate<String> pre = (x) -> {
      System.out.print(x);
      return false;
    };
    System.out.println(": " + pre.test("hello World"));

    //Consumer<T> - T作为输入，执行某种动作但没有返回值
    Consumer<String> con = (x) -> {
      System.out.println(x);
    };
    con.accept("hello world");

    //Supplier<T> - 没有任何输入，返回T
    Supplier<String> supp = () -> {
      return "Supplier";
    };
    System.out.println(supp.get());

    //BinaryOperator<T> -两个T作为输入，返回一个T作为输出，对于“reduce”操作很有用
    BinaryOperator<String> bina = (x, y) -> {
      System.out.print(x + " " + y);
      return "BinaryOperator";
    };
    System.out.println("  " + bina.apply("hello ", "world"));


  }
}

