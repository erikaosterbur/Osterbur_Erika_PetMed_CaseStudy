package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.controller;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.PetDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.UserDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.VetVisit;
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

    @RequestMapping(value = "/pet/{petId}", method = RequestMethod.GET)
    public ModelAndView viewPet(@PathVariable("petId") Integer petId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("pet/petProfile");

        Pet pet = petDAO.findById(petId);
        List<VetVisit> vetVisitList = petDAO.getById(petId);

        response.addObject("pet", pet);
        response.addObject("vetVisitList", vetVisitList);
        return response;

    }





}
