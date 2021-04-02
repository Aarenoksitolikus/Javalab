package ru.itis.javalab.validation;

import javax.validation.Constraint;
        import javax.validation.Payload;
        import java.lang.annotation.ElementType;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;

@Constraint(validatedBy = SamePasswordsValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPasswords {

    String message() default "Password mismatch";

    String password();
    String checkPassword();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        ValidPasswords[] value();
    }

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
