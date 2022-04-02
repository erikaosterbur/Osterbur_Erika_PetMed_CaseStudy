package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class RegisterFormBean {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;

}
