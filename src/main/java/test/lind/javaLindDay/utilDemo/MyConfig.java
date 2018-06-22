package test.lind.javaLindDay.utilDemo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "project")
public class MyConfig {
  private String version;
  private String name;
}
