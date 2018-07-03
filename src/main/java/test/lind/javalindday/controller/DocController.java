package test.lind.javalindday.controller;

import java.time.YearMonth;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocController {
  public static final String DOC = "/doc";
  public static final String DOC_LIST = "/doc/list";
  public static final String DOC_DO = "/doc/{name}";
  public static final String DOC_CODE = "/doc/{code}/{accountPeriod}";


  @PostMapping(DOC_DO)
  public Map<String, String> doOrder(@PathVariable String name,
                                     @RequestBody Map<String, String> order) {
    return order;
  }

  @GetMapping(DOC_CODE)
  public Map<String, String> index(
      @PathVariable("code") String code,
      @PathVariable YearMonth accountPeriod,
      @RequestParam String info) {
    Map<String, String> maps = new HashMap<>();
    maps.put("name", "Hello");
    maps.put("sex", "1");
    maps.put("code", code);
    maps.put("accountPeriod", accountPeriod.toString());
    maps.put("info", info);

    return maps;
  }

  @GetMapping(DOC_LIST)
  public Map<String, String> list() {
    Map<String, String> maps = new HashMap<>();
    maps.put("name", "Hello");
    maps.put("sex", "1");
    maps.put("buyer", "zzl");
    return maps;
  }
}
