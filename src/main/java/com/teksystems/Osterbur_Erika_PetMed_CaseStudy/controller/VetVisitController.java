package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.controller;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.PetDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.UserDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.VetDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.VetVisitDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Vet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.VetVisit;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean.VetVisitFormBean;
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

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class VetVisitController {

    @Autowired
    private VetVisitDAO vetVisitDAO;

    @Autowired
    private PetDAO petDAO;

    @Autowired
    private VetDAO vetDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AuthenticationFacade authentication;

    @RequestMapping(value = "/vetVisit/{vetVisitId}", method = RequestMethod.GET)
    public ModelAndView viewVetVisit(@PathVariable("vetVisitId") Integer vetVisitId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("vetVisit/vet_visit_profile");

        //Finds the vet visit by id from the URI
        VetVisit vetVisit = vetVisitDAO.findById(vetVisitId);

        //If a vet visit is found with that id, adds the vet visit to the response object
        if(vetVisit!=null){
            Vet vet = vetVisitDAO.getById(vetVisitId);
            response.addObject("vetVisit", vetVisit);
            response.addObject("vet", vet);
        } else{
            //If a vet visit is not found, sends the user to the 404 page
            response.setViewName("/error/404");
        }

        return response;

    }

    @RequestMapping(value = "/vetVisit/register", method = RequestMethod.GET)
    public ModelAndView newVetVisit() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("vetVisit/vet_visit_form");

        VetVisitFormBean form = new VetVisitFormBean();
        response.addObject("form", form);

        getUsername(response);
        return response;
    }

    @RequestMapping(value = "/vetVisit/registerSubmitVetVisit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmitVetVisit(@Valid VetVisitFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        //If the form contains errors, adds the errors to the response object
        if(bindingResult.hasErrors()){
            List<String> errorMessages = new ArrayList<>();

            for(ObjectError error : bindingResult.getAllErrors()){
                errorMessages.add(error.getDefaultMessage());
                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            //Adds the form to the response object
            response.addObject("form", form);

            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);

            getUsername(response);

            response.setViewName("vetVisit/vet_visit_form");

            return response;
        }

        //If a vet visit is not found with the id in the URI, then a new vet visit is created
        VetVisit vetVisit = vetVisitDAO.findById(form.getId());
        if(vetVisit == null){
            vetVisit = new VetVisit();
        }

        //Finds the pet and vet the user chose in the form
        Pet pet = petDAO.findById(form.getPetId());
        Vet vet = vetDAO.findById(form.getVetId());

        //Formats the date so that it can be saved in the correct format in the database
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(form.getDate());

        vetVisit.setDate(date);
        vetVisit.setVaccines(form.getVaccines());
        vetVisit.setNotes(form.getNotes());
        vetVisit.setWeight(form.getWeight());
        vetVisit.setVet(vet);
        vetVisit.setPet(pet);

        vetVisitDAO.save(vetVisit);

        response.setViewName("redirect:/pet/" + pet.getId());
        return response;

    }

    private void getUsername(ModelAndView response) {

        //Gets the currently logged-in user
        String username = authentication.getAuthentication();
        User user = userDAO.findByEmail(username);

        //If the user is found, this method returns a list of pets associated with that user and a full list of vets
        //To be added to the form-select
        if(user != null){
            List<Pet> pets = petDAO.findAllByUserId(user.getId());
            response.addObject("pets", pets);

            List<Vet> vets = vetDAO.findAll();
            response.addObject("vets", vets);
        }
    }

    @Transactional
    @RequestMapping(value="/vetVisit/deleteVetVisit/{vetVisitId}", method={RequestMethod.POST, RequestMethod.GET})
    public ModelAndView deleteVet(@PathVariable("vetVisitId") Integer vetVisitId) throws Exception{
        ModelAndView response = new ModelAndView();

        //Finds the currently logged-in user
        String username = authentication.getAuthentication();
        User user = userDAO.findByEmail(username);

        //Deletes the chosen vet visit
        vetVisitDAO.deleteById(vetVisitId);

        response.setViewName("redirect:/user/home/" + user.getId());

        return response;
    }

}
