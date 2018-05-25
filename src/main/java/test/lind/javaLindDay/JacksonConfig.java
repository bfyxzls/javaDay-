package test.lind.javaLindDay;

import org.javamoney.moneta.Money;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.jackson.datatype.money.MoneyModule;

/**
 * 自动注册的配置，当成是java-bean节点
 */
@Configuration
class JacksonConfig {
  @Bean
public MoneyModule moneyModule() {
  return new MoneyModule().withMonetaryAmount(Money::of);
}
}