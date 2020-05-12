package ikvych.resume.annotation.constraints;

import ikvych.resume.validator.MinLowerCharCountConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {MinLowerCharCountConstraintValidator.class})
public @interface MinLowerCharCount {

    String messages() default "MinLoverCharCount";

    int minCount() default 1;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
