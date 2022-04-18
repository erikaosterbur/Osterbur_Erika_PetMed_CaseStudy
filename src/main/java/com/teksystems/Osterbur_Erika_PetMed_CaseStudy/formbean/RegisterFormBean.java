package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.validation.EmailUnique;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString

public class RegisterFormBean {

    private Integer id;

    @NotBlank(message = "Email is required")
    @EmailUnique(message = "This email is already in use")
    @Email(message = "Not a valid email")
    private String email;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Length(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    @NotBlank(message = "Password is required")
    private String password;

    private String confirmPassword;

}
