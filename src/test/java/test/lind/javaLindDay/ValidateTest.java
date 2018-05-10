package test.lind.javaLindDay;

import lombok.val;
import org.javamoney.moneta.Money;
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

  @Test
  public void test() {
    UserInfo entity = UserInfo.builder()
        .price(Money.of(100, "CNY"))
        .build();
    val obj = webTestClient.post()
        .uri("/add")
        .body(BodyInserters.fromObject(entity))
        .exchange()
        .expectStatus().isEqualTo(400)
        .expectBody();

  }
}
