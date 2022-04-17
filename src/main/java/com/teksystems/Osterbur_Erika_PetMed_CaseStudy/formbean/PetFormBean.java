package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class PetFormBean {

    private Integer id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Type is required")
    private String type;

    @NotBlank(message = "Breed is required")
    private String breed;

    @NotBlank(message = "Birthday is required")
    private String birthday;
    private Integer userId;

}
