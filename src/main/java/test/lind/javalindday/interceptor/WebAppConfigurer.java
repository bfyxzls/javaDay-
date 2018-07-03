package test.lind.javalindday.interceptor;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

  @Override
  public void addInterceptors(InterceptorRegistry interceptorRegistry) {

    //设置（模糊）匹配的url
    // addPathPatterns 用于添加拦截规则
    // excludePathPatterns 用户排除拦截
    List<String> urlPatterns = Lists.newArrayList();
    urlPatterns.add("/doc/**/list");
    interceptorRegistry.addInterceptor(new ValidateDataInterceptor()).addPathPatterns(urlPatterns);

    super.addInterceptors(interceptorRegistry);
  }
}
