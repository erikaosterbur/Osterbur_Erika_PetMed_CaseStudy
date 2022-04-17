package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString

public class RegisterFormBean {

    private Integer id;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Length(min = 8, max = 15, message = "Password must be between 8 and 15 characters")
    @NotBlank(message = "Password is required")
    private String password;

    @Length(min = 8, max = 15, message = "Confirm password must be between 8 and 15 characters")
    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;

}
