package com.guidejourney.model.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

@Data
public class MentorProfileDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String profileImage;

    @NotBlank
    private String name;

    @NotBlank
    private String country;

    @NotBlank
    private String workplace;

    private int yearsExperience;

    @NotBlank
    private String linkedinUrl;

    @NotEmpty
    private Set<String> workAreas;
}
