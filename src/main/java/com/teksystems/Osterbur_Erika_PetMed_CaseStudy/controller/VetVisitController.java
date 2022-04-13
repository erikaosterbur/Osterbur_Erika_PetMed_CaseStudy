package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.controller;


import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.PetDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.VetDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.VetVisitDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Vet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.VetVisit;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean.VetVisitFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/vetvisit/{vetVisitId}", method = RequestMethod.GET)
    public ModelAndView viewVetVisit(@PathVariable("vetVisitId") Integer vetVisitId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("vetVisit/vetVisitProfile");

        VetVisit vetVisit = vetVisitDAO.findById(vetVisitId);
        Vet vet = vetVisitDAO.getById(vetVisitId);


        response.addObject("vetVisit", vetVisit);
        response.addObject("vet", vet);
        return response;

    }

    @RequestMapping(value = "/vetVisit/register", method = RequestMethod.GET)
    public ModelAndView newVetVisit() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("vetVisit/vetVisitForm");

        VetVisitFormBean form = new VetVisitFormBean();
        response.addObject("form", form);

        return response;
    }

    @RequestMapping(value = "/vetvisit/registerSubmitVetVisit", method = RequestMethod.POST)
    public ModelAndView registerSubmitVetVisit(VetVisitFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        VetVisit vetVisit = new VetVisit();
        Pet pet = petDAO.findById(form.getPetId());
        Vet vet = vetDAO.findById(form.getVetId());

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
}
