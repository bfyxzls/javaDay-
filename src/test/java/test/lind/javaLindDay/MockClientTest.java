package test.lind.javaLindDay;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import test.lind.javaLindDay.feignClientDemo.MockClient;

@Configuration
@Profile("integTest")
public class MockClientTest {
  @Bean
  public MockClient mockClient() {
    MockClient client = mock(MockClient.class);
    when(client.balanceSheet(
        anyString()))
        .thenReturn("OK");
    return client;
  }
}
