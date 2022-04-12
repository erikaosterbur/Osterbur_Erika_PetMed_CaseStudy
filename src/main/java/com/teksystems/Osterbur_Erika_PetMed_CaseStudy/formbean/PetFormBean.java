package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PetFormBean {

    private Integer id;
    private String name;
    private String type;
    private String breed;
    private String birthday;
    private Integer userId;

}
