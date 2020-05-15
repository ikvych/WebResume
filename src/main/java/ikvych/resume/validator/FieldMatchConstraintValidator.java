package ikvych.resume.validator;

import ikvych.resume.annotation.constraints.FieldMatch;
import org.springframework.beans.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchConstraintValidator implements ConstraintValidator<FieldMatch, Object> {

    private String first;
    private String second;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.first = constraintAnnotation.first();
        this.second = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        try {
            Object firstValue  = BeanUtils.getPropertyDescriptor(value.getClass(), first).getReadMethod().invoke(value);
            Object secondValue = BeanUtils.getPropertyDescriptor(value.getClass(), second).getReadMethod().invoke(value);
            if ((firstValue == null && secondValue == null) || (firstValue != null && firstValue.equals(secondValue))) {
                return true;
            }
            context.buildConstraintViolationWithTemplate("Паролі повинні співпадати")
                    .addPropertyNode(first)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            return false;
        } catch (Exception ignore) {
            context.buildConstraintViolationWithTemplate("Паролі повинні співпадати")
                    .addPropertyNode(first)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            return false;
        }
    }
}
