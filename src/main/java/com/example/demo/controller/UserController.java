package com.example.demo.controller;


import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private UserService userService;

    private UserController( UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers(ModelMap model) {
        model.addAttribute("message", userService.listUser());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/new";
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, ModelMap modelMap) {
        modelMap.addAttribute(userService.show(id));
        return "/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "/update";
        userService.update(user, id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user) {
        userService.delete(user);
        return "redirect:/";
    }
}

