package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.controller;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.VetDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Vet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean.VetFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class AdminController {

    @Autowired
    private VetDAO vetDAO;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public ModelAndView admin() throws Exception {
        ModelAndView response = new ModelAndView();
        //This is the admin page where they can see the vets in the database and add a vet to the database
        response.setViewName("admin/admin");

        VetFormBean form = new VetFormBean();
        response.addObject("form", form);

        //Finds all the vets in the database
        List<Vet> vets = vetDAO.findAll();

        response.addObject("vets", vets);
        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "admin/vetRegisterSubmit", method = RequestMethod.POST)
    public ModelAndView registerSubmitVet(@Valid VetFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        //After user submits the new vet form, checks to see if there are errors in the form
        if(bindingResult.hasErrors()){
            List<String> errorMessages = new ArrayList<>();

            for(ObjectError error : bindingResult.getAllErrors()){
                errorMessages.add(error.getDefaultMessage());
                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            response.addObject("form", form);

            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);

            //Finds all the vets in the database
            List<Vet> vets = vetDAO.findAll();

            response.addObject("vets", vets);

            response.setViewName("admin/admin");

            return response;
        } else{
            //This method saves the new vet to the database
            Vet vet = new Vet();

            vet.setFirstName(form.getFirstName());
            vet.setLastName(form.getLastName());
            vet.setClinic(form.getClinic());

            vetDAO.save(vet);
            response.setViewName("redirect:/admin");
        }
        return response;
    }


}
