package test.lind.javaLindDay.interfaceDemo;

public interface Formula {

  double calculate(int a);

  default double sqrt(int a) {
    return Math.sqrt(a);
  }

}
