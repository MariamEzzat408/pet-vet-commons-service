package com.petcare.commons.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordResetConfirmDTO {
    private String email;
    private String resetToken;
    private String newPassword;

}
