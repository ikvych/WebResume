package ikvych.resume.annotation.constraints;

import ikvych.resume.validator.MinUpperCharCountConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {MinUpperCharCountConstraintValidator.class})
public @interface MinUpperCharCount {

    String message() default "MinUpperCharCount";

    int minCount() default 0;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
