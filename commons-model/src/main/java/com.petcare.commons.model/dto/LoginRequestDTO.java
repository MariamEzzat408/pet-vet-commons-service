package com.petcare.commons.model.dto;

import com.petcare.commons.model.enums.AuthProvider;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min=8,max=32)
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!]).{8,}$",
            message = "Password must be at least 8 characters and include a number, a letter, and a special character"
    )
    private String password;
    private AuthProvider authProvider;
    private String authId;
    private String deviceInfo;
    private String ipAddress;

}
