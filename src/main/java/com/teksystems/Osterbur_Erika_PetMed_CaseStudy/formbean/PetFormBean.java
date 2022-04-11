package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean;


import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class PetFormBean {

    private Integer id;
    private String name;
    private String type;
    private String breed;
    private Date birthday;
    private Integer userId;

}
