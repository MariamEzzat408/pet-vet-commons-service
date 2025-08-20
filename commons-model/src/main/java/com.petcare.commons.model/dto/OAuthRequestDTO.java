package com.petcare.commons.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OAuthRequestDTO {
    private String code;
    private String redirectUri;
    private String state;
    private String deviceInfo;

}
