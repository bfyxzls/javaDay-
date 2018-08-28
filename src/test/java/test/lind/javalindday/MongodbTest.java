package test.lind.javalindday;

import com.google.common.collect.ImmutableList;
import java.time.YearMonth;
import java.util.List;
import org.javamoney.moneta.Money;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import test.lind.javalindday.model.TaxAmountConfig;

public class MongodbTest {
  @Autowired
  MongoTemplate mongoTemplate;

  @Test
  public void add() {
    List<TaxAmountConfig.AmountConfig> amountConfigs = ImmutableList.of(
        TaxAmountConfig.AmountConfig.builder()
            .rate(1)
            .thresholdMax(5000)
            .thresholdMin(3000)
            .value(10)
            .build()
    );
    TaxAmountConfig taxAmountConfig = TaxAmountConfig.builder()
        .base(3000)
        .accountPeriod(YearMonth.of(2017, 5))
        .amountConfigs(amountConfigs)
        .build();
    mongoTemplate.insert(taxAmountConfig);
  }
}
