package test.lind.javalindday;

import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import test.lind.javalindday.classDemo.BiaozhiCar;
import test.lind.javalindday.classDemo.FengTianCar;
import test.lind.javalindday.classDemo.LombokDemo;
import test.lind.javalindday.collectionDemo.CollectionDemo;
import test.lind.javalindday.collectionDemo.GenericDemo;
import test.lind.javalindday.collectionDemo.GroupDemo;
import test.lind.javalindday.collectionDemo.MapInheritDemo;
import test.lind.javalindday.collectionDemo.StackDemo;
import test.lind.javalindday.collectionDemo.StreamDemo;
import test.lind.javalindday.enumDemo.DescriptionDemo;
import test.lind.javalindday.generic.GenericFunDemo;
import test.lind.javalindday.interfaceDemo.Formula;
import test.lind.javalindday.interfaceDemo.FunctionalInterfaceDemo;
import test.lind.javalindday.model.Person;
import test.lind.javalindday.model.UserDto;
import test.lind.javalindday.model.UserInfo;
import test.lind.javalindday.streamDemo.MapDemo;
import test.lind.javalindday.utilDemo.DateDemo;
import test.lind.javalindday.utilDemo.LoggerDemo;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class JavaLindDayApplication {
  public static void aaa() {
  }

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
    MapDemo.test();

    //class
    new FengTianCar().printName();
    new BiaozhiCar().printName();

    //generic method
    GenericDemo.test();
    GenericDemo.getAll(UserInfo.builder().email("zzl").build());

    //automapper
    UserInfo userinfo = UserInfo.builder().name("zzl").build();
    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(userinfo, userDto);

    ModelMapper modelMapper = new ModelMapper();
    userDto = modelMapper.map(userinfo, UserDto.class);
    System.out.println("userDto.name=" + userDto.getName());
    //group by
    Person.testGroupBy();

    //map demo
    MapInheritDemo.test();

    List<UserDto> userDtos = new ArrayList<>();
    UserDto userDto1 = UserDto.builder().name("zzl").build();
    userDtos.add(userDto1);
    userDtos.add(userDto);
    System.out.println(userDtos.toString());
    System.out.println(userDto1.toString());

    List<String> testArrToStr = new ArrayList<>();
    testArrToStr.add("儿子");
    testArrToStr.add("我");
    testArrToStr.add("爸爸");
    Collections.reverse(testArrToStr);
    System.out.println(String.join("->", testArrToStr));

    MapDemo.testDistinct();
    MapDemo.testMap();
    //函数式接口
    Map<String, String> maps = new HashMap<>();
    Function<String, String> function = (x) -> {
      System.out.print(x + ": ");
      return "Function";
    };
    GenericFunDemo.singletonMap(function, "你炫舞");

    YearMonth from = YearMonth.of(2018, 1);
    YearMonth to = YearMonth.of(2018, 9);
    collectLocalDates(from, to).forEach(System.out::println);

    SpringApplication.run(JavaLindDayApplication.class, args);

  }

  public static List<YearMonth> collectLocalDates(YearMonth start, YearMonth end) {
    return Stream.iterate(start, localDate -> localDate.plusMonths(1))
        .limit(ChronoUnit.MONTHS.between(start, end) + 1)
        .collect(Collectors.toList());
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
