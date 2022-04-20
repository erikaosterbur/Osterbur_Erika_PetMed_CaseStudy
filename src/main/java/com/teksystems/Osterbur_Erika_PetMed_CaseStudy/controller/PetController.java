package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.controller;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.PetDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.UserDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.VetVisit;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean.PetFormBean;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.security.AuthenticationFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class PetController {

    @Autowired
    private PetDAO petDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AuthenticationFacade authentication;


    @RequestMapping(value = "/pet/{petId}", method = RequestMethod.GET)
    public ModelAndView viewPet(@PathVariable("petId") Integer petId) throws Exception {
        ModelAndView response = new ModelAndView();

        //Sets the view to the pet profile jsp
        response.setViewName("pet/pet_profile");

        //Finds pet by id from the URI
        Pet pet = petDAO.findById(petId);

        //If the pet is found, returns the pet and the vet visits associated with that pet
        if(pet!=null){
            List<VetVisit> vetVisitList = petDAO.getById(petId);

            vetVisitList.sort((o1, o2)
                    -> o2.getDate().compareTo(
                    o1.getDate()));

            response.addObject("pet", pet);
            response.addObject("vetVisitList", vetVisitList);
        } else{
            //If the pet is not found, returns the 404 error page
            response.setViewName("/error/404");
        }

        return response;

    }

    @RequestMapping(value = "/pet/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();

        //Sets the view to the new pet form
        response.setViewName("pet/pet_form");

        //Create new form bean and add it to the response object
        PetFormBean form = new PetFormBean();
        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "/pet/registerSubmitPet", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmitPet(@Valid PetFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        //After user submits the new pet form, checks to see if there are errors in the form
        if(bindingResult.hasErrors()){
            List<String> errorMessages = new ArrayList<>();

            for(ObjectError error : bindingResult.getAllErrors()){
                errorMessages.add(error.getDefaultMessage());
                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            response.addObject("form", form);

            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);

            response.setViewName("pet/pet_form");

            return response;
        }

        //Checks to see which user is logged in
        String username = authentication.getAuthentication();
        User user = userDAO.findByEmail(username);

        //If the logged-in user is found, then gets the pet id from the form id
        if(user != null){
            Pet pet = petDAO.findById(form.getId());
            //If the form id is null, that means this is a new pet
            if(pet == null){
                pet = new Pet();
            }

            //Formats date to send it in the correct format to the database
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = formatter.parse(form.getBirthday());

            //Sets pet information
            pet.setName(form.getName());
            pet.setType(form.getType());
            pet.setBreed(form.getBreed());
            pet.setBirthday(birthday);
            pet.setUser(user);

            //Saves pet to the database
            petDAO.save(pet);

            //Redirects user after save to the pet's new profile
            response.setViewName("redirect:/pet/" + pet.getId());
        }
        return response;
    }

    @RequestMapping(value="/pet/edit/{petId}", method = RequestMethod.GET)
    public ModelAndView editPet(@PathVariable("petId") Integer petId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("pet/pet_form");

        Pet pet = petDAO.findById(petId);
        if(pet!=null){
            PetFormBean form = new PetFormBean();

            //Populates the form with the pet's current info
            form.setId(pet.getId());
            form.setName(pet.getName());
            form.setType(pet.getType());
            form.setBreed(pet.getBreed());
            form.setBirthday(pet.getBirthday().toString());

            response.addObject("form", form);
        } else{
            response.setViewName("/error/404");
        }

        return response;

    }

}
