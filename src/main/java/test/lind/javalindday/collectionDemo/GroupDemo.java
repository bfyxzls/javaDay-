package test.lind.javalindday.collectionDemo;

import lombok.Value;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupDemo {
  public void test() {

    List<Product> products = new ArrayList<>();
    products.add(new Product("apple", "1001", Arrays.asList(
        new Item(new Date(2018, 1, 1), 10, new BigDecimal("9.99")))));

    products.add(new Product("apple", "1001", Arrays.asList(
        new Item(new Date(2018, 2, 1), 10, new BigDecimal("19.99")))));

    products.add(new Product("apple", "1001", Arrays.asList(
        new Item(new Date(2018, 3, 1), 10, new BigDecimal("29.99")))));

    products.add(new Product("banana", "1002", Arrays.asList(
        new Item(new Date(2018, 3, 1), 10, new BigDecimal("29.99")))));

    //group by name
    Map<String, List<Product>> groupByPriceMap =
        products.stream().collect(Collectors.groupingBy(Product::getName));


    Function<Product, List<Object>> compositeKey = personRecord ->
        Arrays.asList(personRecord.getName(), personRecord.getCode());

    Map<Object, List<Product>> map =
        products.stream().collect(Collectors.groupingBy(compositeKey));

    List<Product> productList = new ArrayList<>();
    for (Map.Entry<Object, List<Product>> item : map.entrySet()) {
      String name = ((List<Object>) item.getKey()).get(0).toString();
      String code = ((List<Object>) item.getKey()).get(1).toString();
      List<Item> itemList = new ArrayList<>();
      for (Product entity : item.getValue()) {
        itemList.addAll(entity.getItems());
      }
      productList.add(new Product(name, code, itemList));

    }
  }

}

@Value
class Item {
  private Date createAt;
  private int count;
  private BigDecimal price;
}

@Value
class Product {
  private String name;
  private String code;
  private List<Item> items;
}

