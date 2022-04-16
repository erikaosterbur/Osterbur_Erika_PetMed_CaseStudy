package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationFacade implements IAuthenticationFacade {

    @Override
    public  String getAuthentication(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();

    }
}

