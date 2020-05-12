package ikvych.resume.validator;

import ikvych.resume.annotation.constraints.FirstFieldLessThanSecond;
import org.springframework.beans.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;

public class FirstFieldLessThanSecondConstraintValidator implements ConstraintValidator<FirstFieldLessThanSecond, Object> {

    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(FirstFieldLessThanSecond constraintAnnotation) {
        this.firstFieldName = constraintAnnotation.first();
        this.secondFieldName = constraintAnnotation.second();
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            Object firstValue  = BeanUtils.getPropertyDescriptor(value.getClass(), firstFieldName).getReadMethod().invoke(value);
            Object secondValue = BeanUtils.getPropertyDescriptor(value.getClass(), secondFieldName).getReadMethod().invoke(value);
            if(firstValue == null || secondValue == null) {
                return true;
            } else if(firstValue instanceof Comparable<?> && secondValue instanceof Comparable<?>) {
                return ((Comparable<Object>)firstValue).compareTo((Comparable<Object>)secondValue) <= 0;
            } else {
                throw new IllegalArgumentException("first and second fields are not comparable!!!");
            }
        } catch (InvocationTargetException | IllegalAccessException e) {
            return false;
        }
    }


}
