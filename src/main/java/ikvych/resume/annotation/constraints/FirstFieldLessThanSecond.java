package ikvych.resume.annotation.constraints;

import ikvych.resume.validator.FirstFieldLessThanSecondConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {FirstFieldLessThanSecondConstraintValidator.class})
public @interface FirstFieldLessThanSecond {

    String message() default "FirstFieldLessThanSecond";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String first();

    String second();

    @Target({ TYPE, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ikvych.resume.annotation.constraints.FirstFieldLessThanSecond[] value();
    }
}
