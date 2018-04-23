package test.lind.javaLindDay.utilDemo;

import lombok.val;

import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateDemo {

  /**
   * from ~ to total date.
   *
   * @param startDate
   * @param endDate
   * @return
   */
  private static List<Date> dateSplit(Date startDate, Date endDate) {

    Long spi = endDate.getTime() - startDate.getTime();
    Long step = spi / (24 * 60 * 60 * 1000);// 相隔天数

    List<Date> dateList = new ArrayList<>();
    dateList.add(endDate);
    for (int i = 1; i <= step; i++) {
      dateList.add(new Date(dateList.get(i - 1).getTime()
          - (24 * 60 * 60 * 1000)));// 比上一天减一
    }
    return dateList;
  }

  /**
   * from ~ to total months.
   *
   * @param minDate
   * @param maxDate
   * @return
   */
  private static List<String> getMonthBetween(String minDate, String maxDate) {
    ArrayList<String> result = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

    Calendar min = Calendar.getInstance();
    Calendar max = Calendar.getInstance();
    try {
      min.setTime(sdf.parse(minDate));
      min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

      max.setTime(sdf.parse(maxDate));
      max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    Calendar curr = min;
    while (curr.before(max)) {
      result.add(sdf.format(curr.getTime()));
      curr.add(Calendar.MONTH, 1);
    }

    return result;
  }

  public void test() {
    YearMonth fromAt = YearMonth.now();
    YearMonth toAt = YearMonth.of(2019, 10);
    System.out.println("fromDate and toDate:" + toAt.compareTo(fromAt));
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
    val from =YearMonth.of(2018,1).toString();
    val to = YearMonth.of(2018,5).toString();
    val list = getMonthBetween(from, to);
    for (String item : list
        ) {
      System.out.println(item);
    }
  }
}
