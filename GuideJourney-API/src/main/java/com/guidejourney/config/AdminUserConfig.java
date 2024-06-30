package com.guidejourney.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "admin")
public class AdminUserConfig {
    private String email;
    private String password;
    private String role;
}
