package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.controller;


import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.VetDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.VetVisitDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Pet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.Vet;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.VetVisit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class VetVisitController {

    @Autowired
    private VetVisitDAO vetVisitDAO;

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
}
