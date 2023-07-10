package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/allusers")
    public String allUsers(ModelMap model) {
        model.addAttribute("message", usersService.listUser());
        return "users";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute(usersService.show(id));
        return "/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "/update";
        usersService.update(user, id);
        return "redirect:/allusers";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user) {
        usersService.delete(user);
        return "redirect:/allusers";
    }

}
