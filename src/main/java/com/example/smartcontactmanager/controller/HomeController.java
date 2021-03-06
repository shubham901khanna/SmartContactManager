package com.example.smartcontactmanager.controller;

import com.example.smartcontactmanager.dao.UserRepository;
import com.example.smartcontactmanager.entities.User;
import com.example.smartcontactmanager.helper.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home-smart contact manager");

        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About-smart contact manager");

        return "about";
    }

    @RequestMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("title", "Register-smart contact manager");
        model.addAttribute("user", new User());

        return "signup";
    }

    /* handler for registering user*/
    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, @RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model, HttpSession session) {
        try {
            if (!agreement) {
                System.out.println("you have not agreed the terms and condition");
                throw new Exception("you have not agreed the terms and condition");
            }
            user.setRole("ROLE_USER");
            user.setEnabled(true);
            user.setImageurl("default.png");
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));


            System.out.println("Agreement" + agreement);
            System.out.println("User" + user);

            User result = this.userRepository.save(user);
            model.addAttribute("user", new User());

            session.setAttribute("message", new Message("succesfully registered!!", "alert-success") {
            });
            return "signup";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", user);

            session.setAttribute("message", new Message("something went wrong" + e.getMessage(), "alert-danger") {
            });
        }
        return "signup";
    }

    // handler for custom login page
    @GetMapping("/signin")
    public String CustomLogin(Model model) {
        model.addAttribute("title", "Login Page");
        return "login";
    }

}
