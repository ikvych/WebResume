package ikvych.resume.validator;

import ikvych.resume.annotation.constraints.MinUpperCharCount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinUpperCharCountConstraintValidator implements ConstraintValidator<MinUpperCharCount, CharSequence> {

    private int minCount;

    @Override
    public void initialize(MinUpperCharCount constraintAnnotation) {
        this.minCount = constraintAnnotation.minCount();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        int numberOfUpperChar = 0;
        for (int i = 0; i < value.length(); i++) {
            if (Character.isUpperCase(value.charAt(i))) {
                numberOfUpperChar++;
            }
        }
        return numberOfUpperChar >= minCount;
    }
}
