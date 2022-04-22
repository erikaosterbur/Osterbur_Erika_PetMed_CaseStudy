package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Vet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.VetVisit;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;

@Slf4j
@DataJpaTest
@ActiveProfiles({"test", "default"})
@TestMethodOrder(OrderAnnotation.class)
class PetDAOTest {

    @Autowired
    PetDAO petDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    VetDAO vetDAO;

    @Autowired
    VetVisitDAO vetVisitDAO;

    static User user;
    static Pet pet;
    static Vet vet;
    static VetVisit vetVisit;

    @BeforeAll
    static void name() {
        user = new User("erika@mail.com", "Erika", "Osterbur", "password");
        pet = new Pet("Ginny", "Dog", "Border Collie", new Date(), user);
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void savePetTest(){
        petDAO.save(pet);
        Assertions.assertThat(pet.getName()).isEqualTo("Ginny");
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void findByIdTest(){
        petDAO.save(pet);
        Pet expected = petDAO.findById(pet.getId());
        Assertions.assertThat(expected.getName()).isEqualTo(pet.getName());
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateByIdTest(){

        Pet pet1 = petDAO.findById(pet.getId());

        pet1.setName("Ellie");

        petDAO.save(pet);

        Assertions.assertThat(pet1.getName()).isEqualTo(pet.getName());
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void getUserTest(){

        petDAO.save(pet);

        Assertions.assertThat(pet.getUser()).isEqualTo(user);

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deletePetTest(){

        petDAO.save(pet);

        petDAO.deleteById(pet.getId());

        Optional<Pet> optionalPet = Optional.ofNullable(petDAO.findById(pet.getId()));

        Pet tempPet = null;
        if (optionalPet.isPresent()) {
            tempPet = optionalPet.get();
        }

        Assertions.assertThat(tempPet).isNull();
    }

}