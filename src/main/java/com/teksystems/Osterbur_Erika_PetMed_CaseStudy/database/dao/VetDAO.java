package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Vet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.VetVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VetDAO extends JpaRepository<Vet, Long> {

    Vet findById(@Param("id") Integer id);

    List<Vet> findAll();

    @Query(value = "select v.vetVisitList from Vet v where v.id = :id")
    List<VetVisit> getById(@Param("id") Integer id);

}
