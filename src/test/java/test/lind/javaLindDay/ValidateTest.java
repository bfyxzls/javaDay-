package test.lind.javaLindDay;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import lombok.val;
import org.javamoney.moneta.Money;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import test.lind.javaLindDay.model.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ValidateTest {
  @Autowired
  WebTestClient webTestClient;

  @Autowired
  private Validator validator;

  @Test
  public void test() {
    UserInfo entity = UserInfo.builder()
        .price(Money.of(10, "CNY"))
        .build();
    webTestClient.post()
        .uri("/add")
        .body(BodyInserters.fromObject(entity))
        .exchange()
        .expectStatus().isOk();

  }

  @Test
  public void validateTest() {
    UserInfo entity = UserInfo.builder()
        .price(Money.of(81, "CNY"))
        .build();
    Set<ConstraintViolation<UserInfo>> violations = validator.validate(entity);
    for (val item : violations) {
      System.out.println(item.getMessage());
    }
    assertEquals(false, violations.isEmpty());

  }
}
