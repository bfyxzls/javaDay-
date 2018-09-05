package test.lind.javalindday;

import java.util.Arrays;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTest {
  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  public static void insertData(String str) {
    if (str.equals("c")) {
      throw new IllegalArgumentException("this word can't is c");
    }
    System.out.println("print value : " + str);
  }

  @Test(expected = IllegalArgumentException.class)
  public void consumer_exception() {
    List<String> al = Arrays.asList("a", "b", "c", "d");
    al.forEach(ExceptionTest::insertData);
  }

  @Test
  public void consumer_exception_message() {
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("this word can't is c");
    List<String> al = Arrays.asList("a", "b", "c", "d");
    al.forEach(ExceptionTest::insertData);
  }
}
