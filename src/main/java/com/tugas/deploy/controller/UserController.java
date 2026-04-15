package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // Temporary storage for data
    private List<User> userList = new ArrayList<>();

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginAuth(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "20240140147".equals(password)) {
            return "redirect:/home";
        }
        return "redirect:/?error";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("users", userList);
        return "home";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute User user) {
        userList.add(user);
        return "redirect:/home";
    }
}