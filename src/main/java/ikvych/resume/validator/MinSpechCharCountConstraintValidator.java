package ikvych.resume.validator;

import ikvych.resume.annotation.constraints.MinSpechCharCount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinSpechCharCountConstraintValidator implements ConstraintValidator<MinSpechCharCount, CharSequence> {

    private String spechSymbols;
    private int minValue;

    @Override
    public void initialize(MinSpechCharCount constraintAnnotation) {
        this.spechSymbols = constraintAnnotation.spechSymbols();
        this.minValue = constraintAnnotation.minValue();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        int numberOfSpechSymbols = 0;
        for (int i = 0; i < value.length(); i++) {
            if (spechSymbols.indexOf(value.charAt(i)) != -1) {
                numberOfSpechSymbols++;
            }
        }
        return numberOfSpechSymbols >= minValue;
    }
}
