package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.controller;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.UserDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.UserRoleDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.dao.VetDAO;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.database.entity.*;
import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.formbean.RegisterFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("register/register");

        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        return response;
    }


    @RequestMapping(value = "/registerSubmitUser", method = RequestMethod.POST)
    public ModelAndView registerSubmitUser(RegisterFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();

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

        response.setViewName("redirect:/user/" + user.getId() + "/home");
        return response;
    }
//    @RequestMapping(value = "/registerSubmitVet", method = RequestMethod.POST)
//    public ModelAndView registerSubmitVet(RegisterFormBean form) throws Exception {
//
//        ModelAndView response = new ModelAndView();
//
//        Vet vet = vetDAO.findById(form.getId());
//
//        if(vet == null){
//            vet = new Vet();
//        }
//            vet.setEmail(form.getEmail());
//            vet.setFirstName(form.getFirstName());
//            vet.setLastName(form.getLastName());
//            vet.setClinic(form.getClinic());
//            vet.setPassword(form.getPassword());
//            vetDAO.save(vet);
//            response.setViewName("redirect:/vet/" + vet.getId() + "/home");
//
//        return response;
//    }


    @GetMapping("/user/edit/{userId}")
    public ModelAndView editUser(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        User user = userDAO.findById(userId);

        RegisterFormBean form = new RegisterFormBean();

        form.setId(user.getId());
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName());
        form.setLastName(user.getLastName());
        form.setPassword(user.getPassword());
        form.setConfirmPassword(user.getPassword());

        response.addObject("form", form);

        return response;
    }

    @GetMapping("/user/{userId}/home")
    public ModelAndView userHome(@PathVariable("userId") Integer userId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/home");

        User user = userDAO.findById(userId);
        List<Pet> petList = userDAO.getById(userId);


        response.addObject("user", user);
        response.addObject("petList", petList);

        return response;
    }

//    @GetMapping("/vet/{vetId}/home")
//    public ModelAndView vetHome(@PathVariable("vetId") Integer vetId) throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("vet/home");
//
//        Vet vet = vetDAO.findById(vetId);
//        List<VetVisit> vetVisitList = vetDAO.getById(vetId);
//
//        response.addObject("vet", vet);
//        response.addObject("vetVisitList", vetVisitList);
//
//        return response;
//
//    }

}
