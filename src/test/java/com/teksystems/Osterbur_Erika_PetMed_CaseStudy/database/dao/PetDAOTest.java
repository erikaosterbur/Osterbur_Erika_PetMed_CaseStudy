package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Vet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.VetVisit;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;

@DataJpaTest
@ActiveProfiles({"test", "default"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PetDAOTest {

    @Autowired
    PetDAO petDAO;

    @Autowired
    UserDAO userDAO;

    User user;
    Pet pet;
    Vet vet;
    VetVisit vetVisit;

    @BeforeEach
    void name() {
        user = new User("erika@mail.com", "Erika", "Osterbur", "password");
        pet = new Pet("Ginny", "Dog", "Border Collie", new Date(), user);
        vet = new Vet("Sarah", "Nelson", "Tempe Animal Hospital");
        vetVisit = new VetVisit(new Date(), "Rabies", "General wellness visit", (float) 48.2, pet, vet);
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void savePetTest(){

        userDAO.save(user);

        petDAO.save(pet);

        Assertions.assertThat(pet.getName()).isEqualTo("Ginny");
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void findByIdTest(){

        Pet pet = petDAO.findById(1);

        Assertions.assertThat(pet.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void updateByIdTest(){

        Pet pet = petDAO.findById(1);

        pet.setName("Ellie");

        petDAO.save(pet);

        Assertions.assertThat(pet.getName()).isEqualTo("Ellie");
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void getByIdTest(){

        List<VetVisit> vetVisitList = petDAO.getById(pet.getId());

        Assertions.assertThat(pet.getVetVisitList()).isEqualTo(vetVisitList);
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void findAllByUserIdTest(){

        List<Pet> petList = petDAO.findAllByUserId(user.getId());

        Assertions.assertThat(petDAO.findAllByUserId(user.getId())).isEqualTo(petList);
    }

}