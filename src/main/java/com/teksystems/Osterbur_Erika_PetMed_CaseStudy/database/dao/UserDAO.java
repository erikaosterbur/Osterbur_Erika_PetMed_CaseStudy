package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao;


import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User findById(@Param("id") Integer id);

    User findByEmail(String email);


}
