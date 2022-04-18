package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.controller;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.UserDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.User;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.security.AuthenticationFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private AuthenticationFacade authentication;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() throws Exception{
        ModelAndView response = new ModelAndView();

        response.setViewName("index");

        //Checks to see if a user is already logged in
        String username = authentication.getAuthentication();
        User user = userDAO.findByEmail(username);

        //If a user is logged in, redirect to that user's home page
        if(user!=null){
            response.addObject(user);
            response.setViewName("redirect:/user/home/" + user.getId());
        }

        return response;
    }

}