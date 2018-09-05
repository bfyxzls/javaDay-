package test.lind.javalindday;

import com.google.common.collect.ImmutableMap;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class YearMonthTest {
  @Test
  public void lastDay() {
    LocalDate endDay = LocalDate.of(
        2018, 1, 1)
        .with(TemporalAdjusters.lastDayOfMonth());
    Assert.assertEquals(31, endDay.getDayOfMonth());
  }

  @Test
  public void isBefore() {
    YearMonth a1 = YearMonth.of(2018, 06);
    YearMonth a2 = YearMonth.of(2018, 06);
    Assert.assertEquals(true, !a1.isBefore(a2));

  }

  @Test
  public void convert() {
    Map<String, Object> map = ImmutableMap.of("dates", true);
    Assert.assertEquals(true, (Boolean) map.get("dates"));
  }
}
