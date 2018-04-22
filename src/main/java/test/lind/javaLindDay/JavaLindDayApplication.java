package test.lind.javaLindDay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import test.lind.javaLindDay.collection.CollectionDemo;
import test.lind.javaLindDay.collection.StackDemo;
import test.lind.javaLindDay.interfaceExt.Formula;
import test.lind.javaLindDay.interfaceExt.FunctionalInterfaceDemo;

@SpringBootApplication
public class JavaLindDayApplication {

  public static void main(String[] args) {
    System.out.println("hello world!");

    // interface default method.
    Formula formula = new Formula() {
      @Override
      public double calculate(int a) {
        return sqrt(a);
      }
    };
    System.out.println("formula.calculate.sqrt:" + formula.calculate(100));

    Formula formula2 = new Formula() {
      @Override
      public double calculate(int a) {
        return 0;
      }
    };
    System.out.println("formula.sqrt:" + formula.sqrt(100));

    new CollectionDemo().sortList();

    FunctionalInterfaceDemo<String, Integer> converter = (from) -> Integer.valueOf(from);
    Integer converted = converter.convert("123");
    System.out.println(converted); // 123

    // stack demo.
    new StackDemo().test();
    SpringApplication.run(JavaLindDayApplication.class, args);
  }
}
