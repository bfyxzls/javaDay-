package test.lind.javalindday;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.lind.javalindday.feignClientDemo.MockClient;

public class JavaLindDayApplicationTests extends TestBase {

  @Autowired
  MockClient mockClient;

  @Test
  public void testMockClient() {
    //  assertEquals(mockClient.balanceSheet("OK"), "OK");
  }
}
