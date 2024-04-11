package com.example.project.validators;

import com.example.project.annotations.PasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.*;
import java.io.*;

public class PasswordStrengthValidate implements ConstraintValidator<PasswordValidator , String> {

    List<String> weakPasswords;

    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
        weakPasswords = Arrays.asList("12345", "password", "qwerty");
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return password!=null && (!weakPasswords.contains(password));
    }
}
