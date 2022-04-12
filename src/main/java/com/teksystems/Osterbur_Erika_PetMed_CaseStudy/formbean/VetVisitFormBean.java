package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VetVisitFormBean {

    private Integer id;
    private String date;
    private String vaccines;
    private String notes;
    private Integer weight;
    private Integer petId;
    private Integer vetId;

}
