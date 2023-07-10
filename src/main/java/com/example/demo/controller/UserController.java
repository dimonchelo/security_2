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
public class UserController {
    @Autowired
    private UsersService usersService;
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "/update";
        usersService.update(user, id);
        return "redirect:/editSolo";
    }
    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user) {
        usersService.delete(user);
        return "redirect:/login";
    }
    @GetMapping("/editSolo")
    public String editSolo(Principal principal , ModelMap model) {
        User user = usersService.findByUsername(principal.getName());
        model.addAttribute("message", user );
        return "/editSolo";
    }


}

