package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.security;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationFacade implements IAuthenticationFacade {

    @Autowired
    private UserDAO userDAO;

    @Override
    public  String getAuthentication(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();

    }
}

