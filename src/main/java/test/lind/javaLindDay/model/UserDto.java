package test.lind.javaLindDay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder(toBuilder = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  private String name;

  public String getName() {
    return "OK";//对name属性进行控制，值永远为OK
  }
}
