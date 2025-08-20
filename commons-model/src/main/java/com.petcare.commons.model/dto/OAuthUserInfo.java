package com.petcare.commons.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OAuthUserInfo {
    private String email;
    private String name;
}
