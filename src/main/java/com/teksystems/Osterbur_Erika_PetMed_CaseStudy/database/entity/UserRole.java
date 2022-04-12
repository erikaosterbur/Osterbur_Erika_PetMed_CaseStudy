package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="user_roles")

public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="user_role")
    private String userRole;

}
