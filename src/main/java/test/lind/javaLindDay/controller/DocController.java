package test.lind.javaLindDay.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocController {
  public static final String DOC = "/doc/{name}";
  public static final String DOC_LIST = "/doc/list";

  @GetMapping(DOC)
  public Map<String, String> index(@PathVariable String name) {
    Map<String, String> maps = new HashMap<>();
    maps.put("name", "Hello");
    maps.put("sex", "1");
    maps.put("buyer", name);
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
