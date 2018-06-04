package test.lind.javaLindDay;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.lind.javaLindDay.feignClientDemo.MockClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaLindDayApplicationTests {

  @Autowired
  MockClient mockClient;

  @Test
  public void contextLoads() {
    assertEquals(1, 1);
  }

  @Test
  public void testMockClient() {
    assertEquals(mockClient.balanceSheet("OK"), "OK");
  }
}
