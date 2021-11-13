package com.example.smartcontactmanager.controller;

import com.example.smartcontactmanager.dao.UserRepository;
import com.example.smartcontactmanager.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/index")
    public String dashboard(Model model, Principal principle) {
        String userName = principle.getName();
        // get the user details using username(email).
        User user = userRepository.getUserByName(userName);
        model.addAttribute("user", user);
        return "user_dashbaord";
    }
}
