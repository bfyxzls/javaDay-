package test.lind.javalindday.feignClientDemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 模拟其他服务.
 */
@Profile("!integTest")
@FeignClient(name = "serviceName")
public interface MockClient {
  @GetMapping(path = "/balanceSheet/{clientCode}")
  String balanceSheet(String clientCode);
}
