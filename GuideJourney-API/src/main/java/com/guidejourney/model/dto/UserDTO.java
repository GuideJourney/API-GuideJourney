package com.guidejourney.model.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class UserDTO {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}

