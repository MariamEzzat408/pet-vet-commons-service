package com.petcare.commons.model.dto;

import com.petcare.commons.model.enums.ConsentMethod;
import com.petcare.commons.model.enums.ConsentType;

import java.time.LocalDateTime;

public class ConsentResponseDTO {
    private Long id;
    private Long userId;
    private ConsentType consentType;
    private boolean isConsented;
    private LocalDateTime consentDate;
    private LocalDateTime revocationDate;
    private String consentVersion;
    private ConsentMethod consentMethod;
    private String ipAddress;
    private String userAgent;

}
