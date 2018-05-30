package test.lind.javaLindDay.model;

import java.math.BigDecimal;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderInfo {
  private String id;
  private String buyer;
  private BigDecimal totalPrice;
  private Map<String, Map<String, Object>> history;
}
