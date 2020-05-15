package ikvych.resume.validator;

import ikvych.resume.annotation.constraints.FirstYearMonthBeforeSecondYearMonth;
import org.springframework.beans.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.time.YearMonth;

public class FirstYearMonthBeforeSecondYearMonthConstraintValidator implements ConstraintValidator<FirstYearMonthBeforeSecondYearMonth, Object> {

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(FirstYearMonthBeforeSecondYearMonth constraintAnnotation) {
        this.firstFieldName = constraintAnnotation.first();
        this.secondFieldName = constraintAnnotation.second();
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            YearMonth firstValue  = (YearMonth) BeanUtils.getPropertyDescriptor(value.getClass(), firstFieldName).getReadMethod().invoke(value);
            YearMonth secondValue = (YearMonth) BeanUtils.getPropertyDescriptor(value.getClass(), secondFieldName).getReadMethod().invoke(value);
            if(firstValue == null || secondValue == null) {
                return true;
            } else if (firstValue.isBefore(secondValue)) {
                return true;
            }
            context.buildConstraintViolationWithTemplate("Дата закінчення повинна йти пізніше дати початку")
                    .addPropertyNode(secondFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            return false;
        } catch (InvocationTargetException | IllegalAccessException e) {
            return false;
        }
    }


}
