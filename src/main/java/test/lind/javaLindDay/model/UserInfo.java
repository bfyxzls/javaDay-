package test.lind.javaLindDay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.javamoney.moneta.Money;
import test.lind.javaLindDay.annotationDemo.MaxMoney;
import test.lind.javaLindDay.annotationDemo.MinMoney;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
  private String name;
  private String email;
  @MinMoney(value = 0, message = "金额不能小于0.")
  @MaxMoney(value = 10, message = "金额不能大于10.")
  private Money price;

}
