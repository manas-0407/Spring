package com.example.project.models;

import com.example.project.annotations.FieldsValueMatch;
import com.example.project.annotations.PasswordValidator;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import java.util.*;
import java.io.*;

@Data
@Entity
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "pwd",
                fieldMatch = "confirmPwd",
                message = "Password Not Matched !"
        ),
        @FieldsValueMatch(
                field = "email",
                fieldMatch = "confirmEmail",
                message = "Email Address Not Matched !"
        )
})
public class Person extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int personId;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotBlank(message = "Mobile Number must not be blank")
    private String mobileNumber;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Please Give a valid email")
    private String email;

    @NotBlank(message = "Confirm email must not be blank")
    @Email(message = "Please Give a valid confirm email")
    @Transient
    private String confirmEmail;

    @NotBlank(message = "Password must not be blank")
    @PasswordValidator
    private String pwd;

    @NotBlank(message = "Confirm Password must not be blank")
    @Transient
    private String confirmPwd;
}
