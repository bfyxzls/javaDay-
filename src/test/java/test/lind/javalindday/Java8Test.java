package test.lind.javalindday;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.junit.Test;

public class Java8Test {

  List<String> names2 = Arrays.asList("a1", "b2", "a2", "c3");

  public static void printData(String str) {
    System.out.println("print value : " + str);
  }


  @Test
  public void consumer_success() {
    List<String> al = Arrays.asList("a", "b", "c", "d");
    al.forEach(Java8Test::printData);
    //下面的方法和上面等价的
    Consumer<String> methodParam = Java8Test::printData; // 方法参数
    al.forEach(x -> methodParam.accept(x));// 方法执行accept
  }

  @Test
  public void sort_asc() {
    Collections.sort(names2, (s1, s2) -> s1.compareTo(s2));
    names2.forEach(System.out::println);
  }

  @Test
  public void sort_desc() {
    Collections.sort(names2, (s1, s2) -> s2.compareTo(s1));
    names2.forEach(System.out::println);
  }

  @Test
  public void forEach() {
    Arrays.asList(1, 2, 3, 4, 5).forEach(o -> System.out.println(o));
  }

  @Test
  public void defaultFunctionInterface() {
    System.out.println(new DefaultFunctionInterfaceImpl().defaultFunction());
  }

  @Test
  public void filter() {
    names2.stream()
        .filter(o -> o.contains("a"))
        .sorted()
        .collect(Collectors.toList());
  }

  @Test
  public void optional() {
    List<String> name = Optional.ofNullable(names2).orElse(null);
  }

  @Test
  public void thread() {
    TimerTaskThread timerTaskThread = new TimerTaskThread();
    timerTaskThread.produce();
    timerTaskThread.produce();
    timerTaskThread.produce();
    timerTaskThread.produce();
    timerTaskThread.produce();
    timerTaskThread.consume();
    timerTaskThread.consume();
    timerTaskThread.consume();
    timerTaskThread.consume();
    timerTaskThread.consume();

  }

  public interface DefaultFunctionInterface {
    default String defaultFunction() {
      return "default function";
    }
  }

  public class DefaultFunctionInterfaceImpl implements DefaultFunctionInterface {
  }

  public class TimerTaskThread extends Thread {
    static final int MAX_PRODUCT = 5;
    static final int MIN_PRODUCT = 0;
    int product;

    public TimerTaskThread() {
      super.setName("TimerTaskThread");
    }

    /**
     * 生产者生产出来的产品交给店员
     */
    public synchronized void produce() {
      if (this.product >= MAX_PRODUCT) {
        try {
          wait();
          System.out.println("产品已满,请稍候再生产");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        return;
      }

      this.product++;
      System.out.println("生产者生产第" + this.product + "个产品.");
      notifyAll();   //通知等待区的消费者可以取出产品了
    }

    /**
     * 消费者从店员取产品
     */
    public synchronized void consume() {
      if (this.product <= MIN_PRODUCT) {
        try {
          wait();
          System.out.println("缺货,稍候再取");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        return;
      }

      System.out.println("消费者取走了第" + this.product + "个产品.");
      this.product--;
      notifyAll();   //通知等待去的生产者可以生产产品了
    }
  }

}
