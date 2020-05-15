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
	public void initialize(final FirstFieldLessThanSecond constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		try {
			Integer firstValue  = (Integer) BeanUtils.getPropertyDescriptor(value.getClass(), firstFieldName).getReadMethod().invoke(value);
			Integer secondValue = (Integer) BeanUtils.getPropertyDescriptor(value.getClass(), secondFieldName).getReadMethod().invoke(value);
			if(firstValue == null || secondValue == null) {
				return true;
			} else if (firstValue <= secondValue) {
				return true;
			} else {
				context.buildConstraintViolationWithTemplate("Дата закінчення повинна йти пізніше дати початку")
						.addPropertyNode(secondFieldName)
						.addConstraintViolation()
						.disableDefaultConstraintViolation();
				return false;
			}
		} catch (InvocationTargetException | IllegalAccessException e) {
			return false;
		}
	}
}
