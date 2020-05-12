package ikvych.resume.annotation.constraints;

import ikvych.resume.validator.MinDigitCountConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {MinDigitCountConstraintValidator.class})
public @interface MinDigitCount {

    String messages() default "MinDigitCount";

    int minCount() default 1;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
