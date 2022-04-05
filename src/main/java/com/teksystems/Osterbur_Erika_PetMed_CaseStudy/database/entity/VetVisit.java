package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vet_visits")
public class VetVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private Date vetVisitDate;

    @Column(name = "vaccines")
    private String vaccines;

    @Column(name = "notes")
    private String notes;

    @Column(name = "weight")
    private Integer weight;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "pet_id", nullable=false)
    private Pet pet;


    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "vet_id", nullable = false)
    private Vet vet;




}
