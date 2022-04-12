package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.controller;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.PetDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.UserDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.VetVisit;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean.PetFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class PetController {

    @Autowired
    private PetDAO petDAO;

    @Autowired
    private UserDAO userDAO;


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

    @RequestMapping(value = "/pet/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("pet/petForm");

        PetFormBean form = new PetFormBean();
        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "/pet/registerSubmitPet", method = RequestMethod.POST)
    public ModelAndView registerSubmitPet(PetFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        Pet pet = new Pet();
        User user = userDAO.findById(form.getUserId());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = formatter.parse(form.getBirthday());

        pet.setName(form.getName());
        pet.setType(form.getType());
        pet.setBreed(form.getBreed());
        pet.setBirthday(birthday);
        pet.setUser(user);

        petDAO.save(pet);


        response.setViewName("redirect:/user/" + user.getId() + "/home");
        return response;
    }





}
