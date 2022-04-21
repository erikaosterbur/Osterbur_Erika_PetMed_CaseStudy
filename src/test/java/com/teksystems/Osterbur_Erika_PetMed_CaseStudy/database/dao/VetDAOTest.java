package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Vet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.VetVisit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.assertj.core.api.Assertions;


import java.util.Date;
import java.util.List;

@Slf4j
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

    static User user;
    static Pet pet;
    static Vet vet1;
    static Vet vet2;
    static VetVisit vetVisit;

    @BeforeAll
    static void name() {
        vet1 = new Vet("Sarah", "Nelson", "Tempe Animal Hospital");
        vet2 = new Vet("Betty", "White", "Lyndale Animal Hospital");

    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveVetTest(){
        vetDAO.save(vet1);
        Assertions.assertThat(vet1.getFirstName()).isEqualTo("Sarah");
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void findByIdTest(){
        vetDAO.save(vet1);
        Vet expected = vetDAO.findById(vet1.getId());
        Assertions.assertThat(expected.getFirstName()).isEqualTo("Sarah");
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void findAllTest(){
        vetDAO.save(vet1);
        vetDAO.save(vet2);
        List<Vet> vetList = vetDAO.findAll();
        Assertions.assertThat(vetDAO.findAll()).isEqualTo(vetList);
    }

}