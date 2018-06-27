package test.lind.javalindday.collectionDemo;

import java.util.HashMap;

public class MapInheritDemo extends HashMap<String, Object> {
  public static void test() {
    MapInheritDemo mapDemo = new MapInheritDemo();
    mapDemo.setCode("1001");
    mapDemo.setName("固定资产");
    mapDemo.put("self", "自定义");
    System.out.println(mapDemo);
  }

  /**
   * 获取code.
   *
   * @return
   */
  public String getCode() {
    return this.get("code").toString();
  }

  /**
   * 设置code.
   *
   * @param code .
   */
  public void setCode(String code) {
    this.put("code", code);
  }

  /**
   * 获取name.
   *
   * @return
   */
  public String getName() {
    return this.get("name").toString();
  }

  /**
   * 设置name.
   *
   * @param name .
   */
  public void setName(String name) {
    this.put("name", name);
  }
}
