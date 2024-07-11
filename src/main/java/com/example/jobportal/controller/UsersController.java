package com.example.jobportal.controller;

import com.example.jobportal.entity.Users;
import com.example.jobportal.entity.UsersType;
import com.example.jobportal.service.UsersService;
import com.example.jobportal.service.UsersTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UsersController {

    private final UsersTypeService usersTypeService;
    private final UsersService usersService;

    @GetMapping("/register")
    public String register(Model model) {
        List<UsersType> usersTypes = usersTypeService.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users newUser) {
//        System.out.println(users);
        usersService.addUser(newUser);
        return "dashboard";
    }
}
