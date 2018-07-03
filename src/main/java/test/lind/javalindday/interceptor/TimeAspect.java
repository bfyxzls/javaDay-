package test.lind.javalindday.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
  @Around("execution(* test.lind.javalindday.controller.DocController.*(..))")
  public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    System.out.println("time aspect start");
    Object[] args = proceedingJoinPoint.getArgs();
    for (Object arg : args) {
     String name=(arg.getClass().getName());
    }
    Object obj = proceedingJoinPoint.proceed();
    System.out.println("time aspect end");
    return obj;
  }
}