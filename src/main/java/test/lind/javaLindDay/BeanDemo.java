package test.lind.javaLindDay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BeanDemo {
  @Bean
  public boolean auto() {
    System.out.println("spring容器启动初始化。。。");
    return true;
  }
}
