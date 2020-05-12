package ikvych.resume.validator;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import ikvych.resume.annotation.constraints.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        try {
            Phonenumber.PhoneNumber number = PhoneNumberUtil.getInstance().parse(value, "");
            return PhoneNumberUtil.getInstance().isValidNumber(number);
        } catch (NumberParseException e) {
            return false;
        }
    }
}
