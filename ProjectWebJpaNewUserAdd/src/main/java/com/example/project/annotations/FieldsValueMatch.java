package com.example.project.annotations;

import com.example.project.validators.FieldsValueMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Email;

import java.lang.annotation.*;

@Constraint(validatedBy = FieldsValueMatchValidator.class)
@Target( { ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(FieldsValueMatch.List.class)
public @interface FieldsValueMatch {
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "Field Values Don't Match !";

    String field();

    String fieldMatch();

    @Target({ ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        FieldsValueMatch[] value();
    }
}
