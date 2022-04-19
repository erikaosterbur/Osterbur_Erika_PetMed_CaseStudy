package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

@DataJpaTest
@ActiveProfiles({"test", "default"})
@TestMethodOrder(OrderAnnotation.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    User user;
    Pet pet;

    @BeforeEach
    void name() {
        user = new User("erika@mail.com", "Erika", "Osterbur", "password");
        pet = new Pet("Ginny", "Dog", "Border Collie", new Date(), user);
    }

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest() {

        userDAO.save(user);

        Assertions.assertThat(user.getEmail()).isEqualTo("erika@mail.com");
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void findByIdTest(){

        User user = userDAO.findById(1);

        Assertions.assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void getById(){

        List<Pet> petList = userDAO.getById(user.getId());

        Assertions.assertThat(user.getPetList()).isEqualTo(petList);
    }

    @Order(4)
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
