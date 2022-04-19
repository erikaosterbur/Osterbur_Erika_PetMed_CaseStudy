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
import org.assertj.core.api.Assertions;


import java.util.Date;
import java.util.List;

@DataJpaTest
@ActiveProfiles({"test", "default"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VetDAOTest {

    @Autowired
    PetDAO petDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    VetDAO vetDAO;

    @Autowired
    VetVisitDAO vetVisitDAO;

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
    public void saveVetTest(){

        userDAO.save(user);

        petDAO.save(pet);

        vetDAO.save(vet);

        vetVisitDAO.save(vetVisit);

        Assertions.assertThat(vet.getFirstName()).isEqualTo("Sarah");
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void findByIdTest(){

        Vet vet = vetDAO.findById(1);

        Assertions.assertThat(vet.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void getByIdTest(){

        List<VetVisit> vetVisitList = vetDAO.getById(vet.getId());

        Assertions.assertThat(vet.getVetVisitList()).isEqualTo(vetVisitList);
    }

}