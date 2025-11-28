package com.campusconnect.backend.services;

import com.campusconnect.backend.dto.AddUserRequestDto;
import com.campusconnect.backend.dto.UserDto;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    UserDto createNewUser(AddUserRequestDto addUserRequestDto);

    void deleteUserById(Long id);

    UserDto updateUser(Long id, AddUserRequestDto addUserRequestDto);

    UserDto updateUser(Long id, Map<String, Object> updates);
}
