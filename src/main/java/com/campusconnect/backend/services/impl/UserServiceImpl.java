package com.campusconnect.backend.services.impl;

import com.campusconnect.backend.dto.AddUserRequestDto;
import com.campusconnect.backend.dto.UserDto;
import com.campusconnect.backend.entity.User;
import com.campusconnect.backend.repository.UserRepository;
import com.campusconnect.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(user -> new UserDto(user.getId(), user.getName(), user.getEmail())).toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        User user= userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not found with ID : "+id));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto createNewUser(AddUserRequestDto addUserRequestDto) {
        User newUser = modelMapper.map(addUserRequestDto, User.class);
        User user = userRepository.save(newUser);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void deleteUserById(Long id) {
        if(!userRepository.existsById(id)){
            throw new IllegalArgumentException("User does not exist with ID : "+id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(Long id, AddUserRequestDto addUserRequestDto) {
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not found with ID : "+id));
        modelMapper.map(addUserRequestDto, user);

        user= userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(Long id, Map<String, Object> updates) {
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not found with ID : "+id));
        updates.forEach((field,value)-> {
            switch(field){
                case "name":user.setName((String)value);
                break;
                case "email":user.setEmail((String)value);
                break;
                default:
                    throw new IllegalArgumentException("Field is not supported.");
            }
        });
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }
}
