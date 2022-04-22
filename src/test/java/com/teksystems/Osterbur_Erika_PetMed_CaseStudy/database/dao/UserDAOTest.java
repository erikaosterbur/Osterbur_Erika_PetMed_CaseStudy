package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.Optional;

@Slf4j
@DataJpaTest
@ActiveProfiles({"test", "default"})
@TestMethodOrder(OrderAnnotation.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PetDAO petDAO;

    static User user;
    static Pet pet;

    @BeforeAll
    static void init() {
        user = new User("erika@mail.com", "Erika", "Osterbur", "password");
        pet = new Pet("Ginny", "Dog", "Border Collie", new Date(), user);
    }

    @Test
    @Rollback(value = false)
    @Order(1)
    void saveUserTest() {
        userDAO.save(user);
        petDAO.save(pet);

        Assertions.assertThat(user.getEmail()).isEqualTo("erika@mail.com");
    }

    @Test
    @Rollback(value = false)
    @Order(2)
    void findByIdTest(){
        userDAO.save(user);
        petDAO.save(pet);
        User expected = userDAO.findById(userDAO.findByEmail(user.getEmail()).getId());

        Assertions.assertThat(expected.getFirstName()).isEqualTo("Erika");
    }


    @Order(3)
    @ParameterizedTest
    @CsvSource({"holly@mail.com,password,Holly,Harper", "pam@mail.com,password,Pam,Popper", "jenny@mail.com,password,Jenny,Jones"})
    void parameterizedTest(String email, String password, String firstName, String lastName) {

        User expected = new User();
        expected.setEmail(email);
        expected.setPassword(password);
        expected.setFirstName(firstName);
        expected.setLastName(lastName);
        userDAO.save(expected);

        User actual = userDAO.findById(expected.getId());

        Assertions.assertThat(expected).isEqualTo(actual);
    }

}
