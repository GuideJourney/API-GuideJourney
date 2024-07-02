package com.guidejourney.model;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class ProfileSelectionDTO {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String profileType;
}
