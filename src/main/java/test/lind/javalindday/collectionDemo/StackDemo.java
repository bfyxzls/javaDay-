package test.lind.javalindday.collectionDemo;

import java.util.Stack;

public class StackDemo {
  public void test() {
    Stack<String> stackList = new Stack<String>();
    stackList.push("1");
    stackList.push("2");
    stackList.push("3");

    System.out.println("LIFO");

    //队列方式遍历，元素逐个被移除
    while (!stackList.isEmpty()) {
      System.out.println(stackList.pop());
    }
  }
}