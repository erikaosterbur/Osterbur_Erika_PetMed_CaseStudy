package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vets")
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer vetId;

    @Column(name = "first_name")
    private String vetFirstName;

    @Column(name = "last_name")
    private String vetLastName;

    @Column(name = "clinic")
    private String clinic;

    @OneToMany(mappedBy = "vet")
    private List<VetVisit> vetVisitList;
}
