package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Vet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.VetVisit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.Optional;


@DataJpaTest
@ActiveProfiles({"test", "default"})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VetVisitDAOTest {
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
    public void saveVetVisitTest(){

        userDAO.save(user);

        petDAO.save(pet);

        vetDAO.save(vet);

        vetVisitDAO.save(vetVisit);

        Assertions.assertThat(vetVisit.getVet()).isEqualTo(vet);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void findByIdTest(){

        VetVisit vetVisit = vetVisitDAO.findById(1);

        Assertions.assertThat(vetVisit.getId()).isEqualTo(1);

    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void getByIdTest(){

        VetVisit vetVisit = vetVisitDAO.findById(1);
        Vet vet = vetVisitDAO.getById(vetVisit.getId());

        Assertions.assertThat(vetVisit.getVet()).isEqualTo(vet);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void deleteByIdTest(){
        vetVisitDAO.deleteById(vetVisit.getId());

        Optional<VetVisit> optionalVetVisit = Optional.ofNullable(vetVisitDAO.findById(vetVisit.getId()));

        VetVisit tempVetVisit = null;
        if (optionalVetVisit.isPresent()) {
            tempVetVisit = optionalVetVisit.get();
        }

        Assertions.assertThat(tempVetVisit).isNull();
    }

}