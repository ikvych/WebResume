package ikvych.resume.validator;

import ikvych.resume.annotation.constraints.MinLowerCharCount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinLowerCharCountConstraintValidator implements ConstraintValidator<MinLowerCharCount, CharSequence> {

    private int minCount;

    @Override
    public void initialize(MinLowerCharCount constraintAnnotation) {
        this.minCount = constraintAnnotation.minCount();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        int numberOfCount = 0;
        for (int i = 0; i < value.length(); i++) {
            if (Character.isLowerCase(value.charAt(i))) {
                numberOfCount++;
            }
        }
        return numberOfCount >= minCount;
    }
}
