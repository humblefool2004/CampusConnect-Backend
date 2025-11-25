package com.campusconnect.backend.controller;

import com.campusconnect.backend.entity.UserDto;
import com.campusconnect.backend.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userServices;

    public UserController(UserService userServices) {
        this.userServices = userServices;
    }
    @GetMapping("/user")
    public UserDto getUser() {
        return userServices.getUser();
    }
    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userServices.getAllUsers();
    }
}
