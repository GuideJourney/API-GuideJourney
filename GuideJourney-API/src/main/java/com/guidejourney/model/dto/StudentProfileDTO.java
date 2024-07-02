package com.guidejourney.model.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

@Data
public class StudentProfileDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String profileImage;

    @NotBlank
    private String name;

    @NotBlank
    private String country;

    @NotBlank
    private String school;

    @NotEmpty
    private Set<String> interests;
}
