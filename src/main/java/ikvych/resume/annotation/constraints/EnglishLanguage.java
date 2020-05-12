package ikvych.resume.annotation.constraints;

import ikvych.resume.validator.EnglishLanguageConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {EnglishLanguageConstraintValidator.class})
public @interface EnglishLanguage {

    String message() default "EnglishLanguage";

    // 0123456789
    boolean withNumbers() default true;

    //.,?!-:()'"[]{}; \t\n
    boolean withPunctuations() default true;

    //~#$%^&*-+=_\\|/@`!'\";:><,.?{}
    boolean withSpechSymbols() default true;

    Class<? extends Payload>[] payload() default { };

    Class<?>[] groups() default { };
}
