package test.lind.javalindday.interceptor;


import java.time.YearMonth;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

public class ValidateDataInterceptor implements HandlerInterceptor {

  /**
   * 进行处理器拦截，action之前执行
   *
   * @param request
   * @param response
   * @param handler
   * @return
   * @throws Exception
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    switch (request.getMethod()) {
      case "GET":
      case "POST":

      case "PUT":
      case "DELETE":
        Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
String value = (String) pathVariables.get("code");
        YearMonth accountPeriod = YearMonth.parse(pathVariables.get("accountPeriod").toString());
        if (value.equals("1")) {
          throw new IllegalArgumentException("值不为1");
          //return false;//value为1请求结束
        }
        break;
      default:
        break;
    }
    return true;
  }

  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                         @Nullable ModelAndView modelAndView) throws Exception {
    int a = 1;
  }
}
