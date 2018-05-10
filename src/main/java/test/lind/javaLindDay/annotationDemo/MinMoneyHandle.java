package test.lind.javaLindDay.annotationDemo;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.javamoney.moneta.Money;

public class MinMoneyHandle implements ConstraintValidator<MinMoney, Money> {
  MinMoney constraint;

  public void initialize(MinMoney constraint) {
    this.constraint = constraint;
  }

  public boolean isValid(Money value, ConstraintValidatorContext context) {
    return value.getNumber().doubleValue() >= constraint.value();
  }

}
