package test.lind.javaLindDay.collectionDemo;

import java.util.List;

public class GenericDemo {
  // 泛型方法 printArray
  public static <E> void printArray(E[] inputArray) {
    // 输出数组元素
    for (E element : inputArray) {
      System.out.printf("%s ", element);
    }
    System.out.println();
  }

  public static <T> List<T> getAll(T entity) {
    System.out.println(entity.getClass().getName());
    return null;
  }

  // 比较三个值并返回最大值
  public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
    T max = x; // 假设x是初始最大值
    if (y.compareTo(max) > 0) {
      max = y; //y 更大
    }
    if (z.compareTo(max) > 0) {
      max = z; // 现在 z 更大
    }
    return max; // 返回最大对象
  }

  public static void test() {
    Integer[] intArray = {1, 2, 3, 4, 5};
    printArray(intArray);
    maximum(1, 4, 7);
  }
}
