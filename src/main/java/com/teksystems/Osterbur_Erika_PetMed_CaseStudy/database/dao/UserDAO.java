package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    User findById(@Param("id") Integer id);

    User findByEmail(String email);

    List<User> findByFirstName(String firstName);

    List<User> findByFirstNameAndLastName(String firstName, String lastName);

    @Query(value = "select u.petList from User u where u.id = :id")
    List<Pet> getById(@Param("id") Integer id);



}
