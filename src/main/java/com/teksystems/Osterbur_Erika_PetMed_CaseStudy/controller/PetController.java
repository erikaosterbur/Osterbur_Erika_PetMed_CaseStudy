package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.controller;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.PetDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.UserDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.VetVisit;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean.PetFormBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
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

        vetVisitList.sort((o1, o2)
                -> o2.getDate().compareTo(
                o1.getDate()));

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

    @RequestMapping(value = "/pet/registerSubmitPet", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmitPet(PetFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        if(!StringUtils.equals("anonymousUser", currentPrincipalName)){
            User user = userDAO.findByEmail(currentPrincipalName);

            Pet pet = petDAO.findById(form.getId());
            if(pet == null){
                pet = new Pet();
            }

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = formatter.parse(form.getBirthday());

            pet.setName(form.getName());
            pet.setType(form.getType());
            pet.setBreed(form.getBreed());
            pet.setBirthday(birthday);
            pet.setUser(user);

            petDAO.save(pet);


            response.setViewName("redirect:/user/home/" + user.getId());

        }

        return response;
    }

    @RequestMapping(value="/pet/edit/{petId}", method = RequestMethod.GET)
    public ModelAndView editPet(@PathVariable("petId") Integer petId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("pet/petForm");

        Pet pet = petDAO.findById(petId);

        PetFormBean form = new PetFormBean();

        form.setId(pet.getId());
        form.setName(pet.getName());
        form.setType(pet.getType());
        form.setBreed(pet.getBreed());
        form.setBirthday(pet.getBirthday().toString());

        response.addObject("form", form);

        return response;

    }



}
