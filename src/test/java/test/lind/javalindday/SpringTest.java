package test.lind.javalindday;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.lind.javalindday.caching.UserRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class SpringTest {

  @Autowired
  UserRepository userRepository;

  @Test
  public void testCache() {
    for (int i = 0; i < 10; i++) {
      try {
        System.out.println(userRepository.findAll());
        Thread.sleep(1000);
      } catch (Exception ex) {
      }

    }
  }

  @Test
  public void testNoCache() {
    for (int i = 0; i < 10; i++) {
      try {
        System.out.println(userRepository.findAllNoCache());
        Thread.sleep(1000);
      } catch (Exception ex) {
      }

    }
  }
}
