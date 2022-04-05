package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.controller;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.PetDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.UserDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class PetController {

    @Autowired
    private PetDAO petDAO;

    @RequestMapping(value = "/pet", method = RequestMethod.GET)
    public ModelAndView viewPet() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("pet/petProfile");

        Pet pet = petDAO.findByName("Ginny");

        response.addObject("pet", pet);
        return response;

    }


//    @Autowired
//    private PetDAO petDAO;
//    @Autowired
//    private UserDAO userDAO;
//
//    @RequestMapping(value = "/user/{userId}/pets", method = RequestMethod.GET)
//    public ModelAndView viewPets(@PathVariable("userId") Integer userId) throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("home");
//
//
//        User user = userDAO.findById(userId);
//
//        List<Pet> petList = petDAO.findAllByUser(user);
//
//        response.addObject("petList", petList);
//
//        return response;
//    }


}
