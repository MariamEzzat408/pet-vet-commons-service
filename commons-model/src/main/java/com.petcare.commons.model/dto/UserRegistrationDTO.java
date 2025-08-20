package com.petcare.commons.model.dto;

import com.petcare.commons.model.enums.AuthProvider;
import com.petcare.commons.model.enums.PreferredLanguage;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDTO {

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Email must be a valid format like example@domain.com"
    )
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min=8,max = 32,message = "Password must be between 8 and 32 characters")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
    )
    private String password;

    @NotBlank(message = "Name is required")
    @Pattern(
            regexp = "^[A-Za-z\\s]+$",
            message = "Name must contain only English letters"
    )
    private String name;

    @NotBlank(message = "Arabic name is required")
    @Pattern(
            regexp = "^[\\u0600-\\u06FF\\s]+$",
            message = "Arabic name must contain only Arabic letters"
    )
    private String nameAr;


    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number must be between 10 and 15 digits")
    private String phone;

    @NotNull(message = "Preferred language is required")
    private PreferredLanguage preferredLanguage;

    @NotNull(message = "Auth provider is required")
    private AuthProvider authProvider;

    @NotBlank(message = "Auth ID is required")
    private String authId;

    @AssertTrue(message = "You must consent to data processing")
    private boolean consentToDataProcessing;

    private boolean consentToMarketingEmails;


}
