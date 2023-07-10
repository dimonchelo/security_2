//package com.example.demo.controller;
//
//
//import com.example.demo.model.User;
//import jakarta.validation.Valid;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//
//@Controller
//public class UserController {
//    private UsersService usersService;
//
//    private UserController( UserService userService) {
//        this.userService = userService;
//    }

//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable("id") int id, ModelMap modelMap) {
//        modelMap.addAttribute(userService.show(id));
//        return "/update";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {
//        if (bindingResult.hasErrors())
//            return "/update";
//        userService.update(user, id);
//        return "redirect:/";
//    }

//}

