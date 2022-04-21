package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Vet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.VetVisit;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.Optional;

@Slf4j
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

    static User user;
    static Pet pet;
    static Vet vet;
    static VetVisit vetVisit;

    @BeforeAll
    static void name() {
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
        userDAO.save(user);
        petDAO.save(pet);
        vetDAO.save(vet);
        vetVisitDAO.save(vetVisit);

        VetVisit vetVisit1 = vetVisitDAO.findById(vetVisit.getId());

        Assertions.assertThat(vetVisit1.getNotes()).isEqualTo(vetVisit.getNotes());

    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void getVetTest(){
        userDAO.save(user);
        petDAO.save(pet);
        vetDAO.save(vet);
        vetVisitDAO.save(vetVisit);

        Assertions.assertThat(vetVisit.getVet()).isEqualTo(vet);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void getPetTest(){
        userDAO.save(user);
        petDAO.save(pet);
        vetDAO.save(vet);
        vetVisitDAO.save(vetVisit);

        Assertions.assertThat(vetVisit.getPet()).isEqualTo(pet);
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteByIdTest(){
        userDAO.save(user);
        petDAO.save(pet);
        vetDAO.save(vet);
        vetVisitDAO.save(vetVisit);

        vetVisitDAO.deleteById(vetVisit.getId());

        Optional<VetVisit> optionalVetVisit = Optional.ofNullable(vetVisitDAO.findById(vetVisit.getId()));

        VetVisit tempVetVisit = null;
        if (optionalVetVisit.isPresent()) {
            tempVetVisit = optionalVetVisit.get();
        }

        Assertions.assertThat(tempVetVisit).isNull();
    }

}