package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class RegistrationController {
    @Autowired
    private UsersService usersService;

    public RegistrationController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(ModelMap model) {
        model.addAttribute("user", new User());
        return "/registration";
    }

    @PostMapping("/registration_procces")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/registration";
        usersService.add(user);
        return "redirect:/login";
    }
    @GetMapping("/createAdmin")
    public String createAdmin(ModelMap model) {
        model.addAttribute("user", new User());
        return "/createAdmin";
    }
    @PostMapping("/createAdmin_procces")
    public String addAdmin(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/createAdmin";
        usersService.addAdmin(user);
        return "redirect:/login";
    }
}
