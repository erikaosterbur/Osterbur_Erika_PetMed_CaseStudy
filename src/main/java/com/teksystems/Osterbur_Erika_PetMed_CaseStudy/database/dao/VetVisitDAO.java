package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.VetVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface VetVisitDAO extends JpaRepository<VetVisit, Long> {

    VetVisit findById(@Param("id") Integer id);

    void deleteById(@Param("id") Integer id);

}
