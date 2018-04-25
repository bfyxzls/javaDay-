package test.lind.javaLindDay.interfaceDemo;

@FunctionalInterface
public interface FunctionalInterfaceDemo<F, T> {
  T convert(F from);
}