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
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "vet_visits")
public class VetVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @NonNull
    @Column(name = "vaccines")
    private String vaccines;

    @NonNull
    @Column(name = "notes")
    private String notes;

    @NonNull
    @Column(name = "weight")
    private Float weight;

    @NonNull
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "pet_id", nullable=false)
    private Pet pet;

    @NonNull
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "vet_id", nullable = false)
    private Vet vet;


}
