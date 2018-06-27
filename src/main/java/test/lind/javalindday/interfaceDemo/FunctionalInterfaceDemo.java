package test.lind.javalindday.interfaceDemo;

@FunctionalInterface
public interface FunctionalInterfaceDemo<F, T> {
  T convert(F from);
}