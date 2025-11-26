package com.campusconnect.backend.services;

import com.campusconnect.backend.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public UserDto getUser(){
        return new UserDto(1,"Saheel","saheel@kiit.com");
    }

    public List<UserDto> getAllUsers(){
        List<UserDto> users = new ArrayList<>();
        users.add(getUser());
        users.add(new UserDto(2,"kajal", "kajal@kiit.com"));
        users.add(new UserDto(3,"kamal","kamal@kiit.com"));
        return users;
    }

}
