package ikvych.resume.annotation.constraints;

import ikvych.resume.validator.FieldMatchConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE, FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {FieldMatchConstraintValidator.class})
public @interface FieldMatch {
    String message() default "FieldMatch";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String first();

    String second();

    @Target({ TYPE, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ikvych.resume.annotation.constraints.FieldMatch[] value();
    }
}
