package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.controller;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.UserDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.UserRoleDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.VetDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.*;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean.RegisterFormBean;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean.VetFormBean;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.security.AuthenticationFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.*;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private VetDAO vetDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationFacade authentication;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("register/register");

        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        return response;
    }


    @RequestMapping(value = "/registerSubmitUser", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView registerSubmitUser(@Valid RegisterFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        if(bindingResult.hasErrors() && form.getPassword() != form.getConfirmPassword()){
            List<String> errorMessages = new ArrayList<>();

            for(ObjectError error : bindingResult.getFieldErrors()){
                errorMessages.add(error.getDefaultMessage());
                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            String notMatch = "Passwords do not match";

            response.addObject("notMatch", notMatch);

            response.addObject("form", form);

            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);

            response.setViewName("register/register");

            return response;
        } else if(bindingResult.hasErrors()){
            List<String> errorMessages = new ArrayList<>();

            for(ObjectError error : bindingResult.getFieldErrors()){
                errorMessages.add(error.getDefaultMessage());
                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);

            response.addObject("errorMessages", errorMessages);
            response.addObject("bindingResult", bindingResult);

            response.setViewName("register/register");

            return response;
        } else if(form.getPassword() != form.getConfirmPassword()){
            String notMatch = "Passwords do not match";

            response.addObject("notMatch", notMatch);

            response.setViewName("register/register");
        } else{
            User user = userDAO.findById(form.getId());

            if(user == null){
                user = new User();
            }
            user.setEmail(form.getEmail());
            user.setFirstName(form.getFirstName());
            user.setLastName(form.getLastName());
            String password = passwordEncoder.encode(form.getPassword());
            user.setPassword(password);

            userDAO.save(user);

            UserRole userRole = new UserRole();
            userRole.setUserId(user.getId());
            userRole.setUserRole("USER");

            userRoleDAO.save(userRole);

            response.setViewName("redirect:/user/home/" + user.getId());
        }

        return response;

    }

    //get working if I have time

//    @GetMapping("/user/edit/{userId}")
//    public ModelAndView editUser(@PathVariable("userId") Integer userId, BindingResult bindingResult) throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("user/register");
//
//        if(bindingResult.hasErrors()){
//            List<String> errorMessages = new ArrayList<>();
//
//            for(ObjectError error : bindingResult.getAllErrors()){
//                errorMessages.add(error.getDefaultMessage());
//                log.info( ((FieldError) error).getField() + " " + error.getDefaultMessage());
//            }
//
//            response.addObject("errorMessages", errorMessages);
//            response.addObject("bindingResult", bindingResult);
//
//            response.setViewName("user/register");
//
//            return response;
//        }
//
//        User user = userDAO.findById(userId);
//        if(user!=null){
//            RegisterFormBean form = new RegisterFormBean();
//
//            form.setId(user.getId());
//            form.setEmail(user.getEmail());
//            form.setFirstName(user.getFirstName());
//            form.setLastName(user.getLastName());
//            form.setPassword(user.getPassword());
//            form.setConfirmPassword(user.getPassword());
//
//            response.addObject("form", form);
//        } else{
//            response.setViewName("/error/404");
//        }
//
//        return response;
//    }
//
    @GetMapping("/user/home")
    public ModelAndView userHome() throws Exception {
        ModelAndView response = new ModelAndView();

        String username = authentication.getAuthentication();
        User user = userDAO.findByEmail(username);

        if(user != null){
            response.addObject("user", user);
            response.setViewName("redirect:/user/home/" + user.getId());
        }

        return response;
    }

    @GetMapping("/user/home/{userId}")
    public ModelAndView userHomePage(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/home");

        User user = userDAO.findById(userId);
        if(user!=null){
            List<Pet> petList = userDAO.getById(userId);
            response.addObject("user", user);
            response.addObject("petList", petList);
        } else{
            response.setViewName("/error/404");
        }

        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public ModelAndView admin() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("admin/admin");

        VetFormBean form = new VetFormBean();
        response.addObject("form", form);

        List<Vet> vets = vetDAO.findAll();

        response.addObject("vets", vets);
        return response;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "admin/vetRegisterSubmit", method = RequestMethod.POST)
    public ModelAndView registerSubmitVet(VetFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

        Vet vet = new Vet();

        vet.setFirstName(form.getFirstName());
        vet.setLastName(form.getLastName());
        vet.setClinic(form.getClinic());

        vetDAO.save(vet);

        response.setViewName("redirect:/admin");
        return response;
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
//    @Transactional
//    @RequestMapping(value="/admin/vetDelete/{vetId}", method={RequestMethod.POST, RequestMethod.GET})
//    public ModelAndView deleteVet(@PathVariable("vetId") Integer vetId) throws Exception{
//        ModelAndView response = new ModelAndView();
//
//        Vet vet = vetDAO.findById(vetId);
//
//        List<VetVisit> vetVisitList = vet.getVetVisitList();
//
//        if(vetVisitList.isEmpty()){
//            vetDAO.deleteById(vetId);
//        }
//
//        response.setViewName("redirect:/admin");
//
//        return response;
//    }

}
