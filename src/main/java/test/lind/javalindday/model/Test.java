package test.lind.javalindday.model;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "test")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Test {
  private String id;
  private String cdn;
  private String domain;
  private Client client;
  private int x;

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  public static class Client {
    Map<String, Employee> employees;
  }

  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  public static class Employee {
    private String userName;
    private String id;
    private int age;
  }
}
