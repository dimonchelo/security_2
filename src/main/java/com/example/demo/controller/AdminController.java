package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    private UsersService usersService;
    @GetMapping("/new")
    public String newUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping("/new_procces")
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/new";
        usersService.add(user);
        return "redirect:/allusers";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute(usersService.show(id));
        return "/update";
    }
    @GetMapping("/allusers")
    public String allUsers(ModelMap model) {
        model.addAttribute("message", usersService.listUser());
        return "/users";
    }
}
