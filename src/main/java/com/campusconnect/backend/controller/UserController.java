package com.campusconnect.backend.controller;

import com.campusconnect.backend.dto.AddUserRequestDto;
import com.campusconnect.backend.dto.UserDto;
import com.campusconnect.backend.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<UserDto>> getUser() {

        return ResponseEntity.ok(userService.getAllUsers());
        //200 for ok
    }
   /*
    @GetMapping("/users/{id}/{name}")
    public String getUser(@PathVariable Long id,@PathVariable String name) {
        return "Path Variable " + id+ "Name is " + name;
    }
    */
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid AddUserRequestDto addUserRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(addUserRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody @Valid AddUserRequestDto addUserRequestDto) {
      return ResponseEntity.ok(userService.updateUser(id,addUserRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(userService.updateUser(id, updates));
    }
}
