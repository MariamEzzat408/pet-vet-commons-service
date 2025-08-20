package com.petcare.commons.model.dto;

import com.petcare.commons.model.enums.PreferredLanguage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {

    @NotBlank
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

    @NotBlank(message = "Current Password is required")
    @Size(min=8,max = 32,message = "Password must be between 8 and 32 characters")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
    )
    private String currentPassword;
    private String newPassword;

}
