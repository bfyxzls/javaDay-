package test.lind.javalindday.annotationDemo;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.javamoney.moneta.Money;

public class MaxMoneyHandle implements ConstraintValidator<MaxMoney, Money> {
  MaxMoney constraint;

  public void initialize(MaxMoney constraint) {
    this.constraint = constraint;
  }

  public boolean isValid(Money value, ConstraintValidatorContext context) {
    return value.getNumber().doubleValue() <= constraint.value();
  }

}
