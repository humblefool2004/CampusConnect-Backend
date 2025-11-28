package com.campusconnect.backend.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequestDto {
    @NotBlank(message = "Name is required")
    @Size(min=3, max=30, message = "Name should be within [3,30] characters")
    private String name;
    @Email
    @NotBlank(message = "email is required")
    private String email;

}