package test.lind.javalindday.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.javamoney.moneta.Money;
import test.lind.javalindday.annotationDemo.MaxMoney;
import test.lind.javalindday.annotationDemo.MinMoney;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
  private String name;
  private String email;
  @MinMoney(message = "金额不能小于0.")
  @MaxMoney(value = 10, message = "金额不能大于10.")
  private Money price;
  private Integer age;

}
