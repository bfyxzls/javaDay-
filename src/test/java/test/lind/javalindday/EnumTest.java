package test.lind.javalindday;

import org.junit.Assert;
import org.junit.Test;

public class EnumTest {
  @Test
  public void convert() {
    Assert.assertEquals("护照", IdType.valueOf("Passport").description());
  }

  @Test
  public void description() {
    Assert.assertEquals("护照", IdType.Passport.description());
  }

  enum IdType {
    IdentityCard("身份证"),
    OfficerCard("军官证"),
    SoldiersCard("士兵证"),
    Passport("护照"),
    PoliceOfficerCard("武警军官证"),
    HkMacaoTwPassport("港澳台通行证"),
    Other("其他");

    private final String description;

    private IdType(String description) {
      this.description = description;
    }

    public String description() {
      return this.description;
    }
  }
}
