package test.lind.javalindday.caching;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
  /**
   * 查询全部用户
   *
   * @return
   */
  @Cacheable(cacheNames = "user.service.all")
  public String findAll() {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    return df.format(new Date());
  }

  public String findAllNoCache() {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    return df.format(new Date());
  }
}
