package test.lind.javalindday.annotationDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target( {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MaxMoneyHandle.class)
public @interface MaxMoney {
  String message() default "{MaxMoney.message.error}";

  double value() default 0;

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}