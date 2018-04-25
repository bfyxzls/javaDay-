package test.lind.javaLindDay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import test.lind.javaLindDay.classDemo.LombokDemo;
import test.lind.javaLindDay.collectionDemo.CollectionDemo;
import test.lind.javaLindDay.collectionDemo.GroupDemo;
import test.lind.javaLindDay.collectionDemo.StackDemo;
import test.lind.javaLindDay.enumDemo.DescriptionDemo;
import test.lind.javaLindDay.interfaceDemo.Formula;
import test.lind.javaLindDay.interfaceDemo.FunctionalInterfaceDemo;
import test.lind.javaLindDay.utilDemo.DateDemo;

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
    System.out.println("formula.sqrt:" + formula.sqrt(100));
    new CollectionDemo().sortList();

    // function interface.
    FunctionalInterfaceDemo<String, Integer> converter = (from) -> Integer.valueOf(from);
    Integer converted = converter.convert("123");
    System.out.println(converted); // 123

    // stack demo.
    new StackDemo().test();

    // class lombok demo.
    new LombokDemo().test();

    // yearMonth compare.
    new DateDemo().test();

    // find list.
    new CollectionDemo().findList();

    // enum test.
    new DescriptionDemo().test();

    // grouping test.
    new GroupDemo().test();

    SpringApplication.run(JavaLindDayApplication.class, args);
  }
}
