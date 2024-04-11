package com.example.project.annotations;

import com.example.project.validators.PasswordStrengthValidate;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordStrengthValidate.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {

    String message() default "Please choose a strong Password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}