package ikvych.resume.annotation.constraints;

import ikvych.resume.validator.MinSpechCharCountConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {MinSpechCharCountConstraintValidator.class})
public @interface MinSpechCharCount {

    String messages() default "MinSpechCharCount";

    int minValue() default 1;

    String spechSymbols() default "!@~`#$%^&*()_-+=|\\/{}[].,;:/?";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
