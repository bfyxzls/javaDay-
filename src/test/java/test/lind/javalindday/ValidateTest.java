package test.lind.javalindday;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

import org.javamoney.moneta.Money;
import org.junit.Assert;
import org.junit.Test;
import test.lind.javalindday.model.UserInfo;

public class ValidateTest extends TestBase {

  @Test
  public void importClass() {
    List<UserInfo> userinfos = new ArrayList<>();
    List<UserInfo> userInfos2 = new ArrayList<>();

    UserInfo userInfo = UserInfo.builder().build();
    userInfo = userInfo.toBuilder().email("zzl@sina.com").build();
    userinfos.add(userInfo);
    for (UserInfo userInfo1 : userinfos) {
     userInfos2.add(userInfo1.toBuilder().email("ok@sina.com").build());
    }
    for (UserInfo userInfo1 : userInfos2) {

      assertEquals(userInfo1.getEmail(), "ok@sina.com");
    }

  }

  @Test
  public void MoneyString(){
    String price=Money.of(1000,"CNY").getNumber().toString();
    Money a1=Money.parse("CNY 3000.00");
    Assert.assertEquals("1000", price);
  }
}
