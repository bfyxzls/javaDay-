package test.lind.javalindday.enumDemo;

import lombok.Getter;

/**
 * 颜色.
 */
enum Color {
  RED,
  GREEN,
  BLACK
}

/**
 * 所属税局.
 */
@Getter
enum TaxBureau {
  NationalBureau("国税局"), LocalBureau("地税局");

  private final String description;

  TaxBureau(String description) {
    this.description = description;
  }
}

/**
 * 枚举测试.
 */
public class DescriptionDemo {

  public void test() {
    for (Color item : Color.values()) {
      System.out.println(item);

    }

    for (TaxBureau item : TaxBureau.values()) {
      System.out.println(item.getDescription());

    }
  }
}