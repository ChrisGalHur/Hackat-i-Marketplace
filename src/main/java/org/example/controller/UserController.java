package org.example.controller;

import org.example.dto.LoginDTO;
import org.example.dto.UserDTO;
import org.example.model.User;
import org.example.service.IUserService;
import org.example.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/appActivitats")
@Validated
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/user")
    public UserDTO registerUser(@Valid @RequestBody UserDTO user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }
}
