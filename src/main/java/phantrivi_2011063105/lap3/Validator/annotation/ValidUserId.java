package phantrivi_2011063105.lap3.Validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import phantrivi_2011063105.lap3.Validator.ValidUserIdValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE,FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidUserIdValidator.class)
@Documented
public @interface ValidUserId {
    String message() default "Invalid User ID";
    Class<?>[] groups() default {};
    Class<? extends jakarta.validation.Payload>[] payload() default {};
}
