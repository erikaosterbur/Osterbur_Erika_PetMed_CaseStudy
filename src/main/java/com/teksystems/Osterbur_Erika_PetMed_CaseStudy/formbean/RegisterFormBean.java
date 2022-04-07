package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString

public class RegisterFormBean {


    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String clinic;
    private String confirmPassword;


}
