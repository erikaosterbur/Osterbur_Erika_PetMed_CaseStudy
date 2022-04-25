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
@RequiredArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "type")
    private String type;

    @NonNull
    @Column(name = "breed")
    private String breed;

    @NonNull
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy="pet", fetch = FetchType.LAZY)
    private List<VetVisit> vetVisitList;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
