package ikvych.resume.validator;

import ikvych.resume.annotation.constraints.Adulthood;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AdulthoodConstraintValidator implements ConstraintValidator<Adulthood, LocalDate> {
    private int adulthoodAge;


    @Override
    public void initialize(Adulthood constraintAnnotation) {
        this.adulthoodAge = constraintAnnotation.adulthoodAge();
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        LocalDate criticalTime = LocalDate.now().minusYears(adulthoodAge);
        return value.isBefore(criticalTime);
    }
}
