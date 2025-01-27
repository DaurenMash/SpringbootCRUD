package org.example.springboot.controller;


import org.example.springboot.entity.User;
import org.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @PostMapping("/edit-user")
    public String editUser(User user) {
        userService.edit(user);
        return "redirect:/";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        if (user.getName().isEmpty()) {
            model.addAttribute("errorMessage",
                    "Ошибка: Объект пользователя не может быть пустым.");
            model.addAttribute("users", userService.findAll());
            return "users";
        }
        userService.add(user);
        return "redirect:/";
    }


    @PostMapping("/delete-user")
    public String deleteUser(@RequestParam("id") Long id, Model model) {
        userService.delete(id);
        return "redirect:/";
    }



}