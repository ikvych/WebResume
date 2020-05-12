package ikvych.resume.validator;

import ikvych.resume.annotation.constraints.MinDigitCount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinDigitCountConstraintValidator implements ConstraintValidator<MinDigitCount, CharSequence> {

    private int minDigitCount;

    @Override
    public void initialize(MinDigitCount constraintAnnotation) {
        this.minDigitCount = constraintAnnotation.minCount();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        int countOfDigit = 0;
        for (int i = 0; i < value.length(); i++) {
            if (Character.isDigit(value.charAt(i))) {
                countOfDigit++;
            }
        }
        return countOfDigit >= minDigitCount;
    }
}
