package com.example.smartcontactmanager.controller;

import com.example.smartcontactmanager.dao.UserRepository;
import com.example.smartcontactmanager.entities.Contact;
import com.example.smartcontactmanager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @ModelAttribute
    public void addCommonData(Model model, Principal principle) {
        String userName = principle.getName();
        // get the user details using username(email).
        User user = userRepository.getUserByName(userName);
        model.addAttribute("user", user);
    }


    @RequestMapping("/index")
    public String dashboard() {
        return "user_dashbaord";
    }

    // handler for add contact
    @GetMapping("/add_contact")
    public String openAddContact(Model model) {
        model.addAttribute("title", "Add Contact");
        model.addAttribute("contact", new Contact());

        return "add_contact_form";
    }
}
