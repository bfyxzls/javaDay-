package test.lind.javaLindDay;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import test.lind.javaLindDay.classDemo.BiaozhiCar;
import test.lind.javaLindDay.classDemo.FengTianCar;
import test.lind.javaLindDay.classDemo.LombokDemo;
import test.lind.javaLindDay.collectionDemo.CollectionDemo;
import test.lind.javaLindDay.collectionDemo.GenericDemo;
import test.lind.javaLindDay.collectionDemo.GroupDemo;
import test.lind.javaLindDay.collectionDemo.StackDemo;
import test.lind.javaLindDay.collectionDemo.StreamDemo;
import test.lind.javaLindDay.enumDemo.DescriptionDemo;
import test.lind.javaLindDay.interfaceDemo.Formula;
import test.lind.javaLindDay.interfaceDemo.FunctionalInterfaceDemo;
import test.lind.javaLindDay.model.UserInfo;
import test.lind.javaLindDay.utilDemo.DateDemo;
import test.lind.javaLindDay.utilDemo.LoggerDemo;

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

    // logger
    new LoggerDemo().test();

    // generic
    List<Integer> ints = new ArrayList<>();
    ints.add(3);
    ints.add(5);
    ints.add(10);
    double sum = sum(ints);
    System.out.println("Sum of ints=" + sum);

    // map reduce
    new StreamDemo().test();

    // lombok demo
    new LombokDemo().test();


    //lambda
    GreetingService greetingService = msg -> System.out.println("lambda.msg=" + msg);
    greetingService.sayMessage("lind.zzl");

    //class
    new FengTianCar().printName();
    new BiaozhiCar().printName();

    //generic method
    GenericDemo.test();
    GenericDemo.getAll( UserInfo.builder().email("zzl").build());

    SpringApplication.run(JavaLindDayApplication.class, args);
  }

  public static double sum(List<? extends Number> list) {
    double sum = 0;
    for (Number n : list) {
      sum += n.doubleValue();
    }
    return sum;
  }

  interface GreetingService {
    void sayMessage(String message);
  }

}
