package test.lind.javalindday.model;

import java.time.YearMonth;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.javamoney.moneta.Money;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 个人所得税配置.
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tax_amount_config")
public class TaxAmountConfig {
  private String id;
  @Valid
  private List<AmountConfig> amountConfigs;
  @NotNull
  private YearMonth accountPeriod;
  @NotNull
  private double base;


  @Builder
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class AmountConfig {
    @NotNull
    private double thresholdMin;
    @NotNull
    private double thresholdMax;
    @NotNull
    private double rate;
    @NotNull
    private double value;
  }
}

