package ikvych.resume.annotation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {})
@MinDigitCount
@MinLowerCharCount
@MinUpperCharCount
@MinSpechCharCount
@Size(min = 8)
public @interface PasswordStrength {

    String message() default "PasswordStrength";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
