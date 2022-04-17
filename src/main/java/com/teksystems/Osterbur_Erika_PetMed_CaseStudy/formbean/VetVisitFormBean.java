package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class VetVisitFormBean {

    private Integer id;

    @NotBlank(message = "Date is required")
    private String date;

    @NotBlank(message = "Vaccines are required (if your pet didn't receive any vaccines, put NA)")
    private String vaccines;

    @NotBlank(message = "Notes are required")
    private String notes;

    @NotNull(message = "Weight is required (if your pet was not weighed, put NA)")
    private Float weight;

    @NotNull(message = "Pet is required")
    private Integer petId;

    @NotNull(message = "Vet is required")
    private Integer vetId;

}
