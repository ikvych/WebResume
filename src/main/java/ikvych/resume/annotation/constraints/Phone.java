package ikvych.resume.annotation.constraints;

import ikvych.resume.validator.PhoneConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {PhoneConstraintValidator.class})
public @interface Phone {

    String message() default "Phone";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
