package com.petcare.commons.model.dto;

import com.petcare.commons.model.enums.ConsentMethod;
import com.petcare.commons.model.enums.ConsentType;

public class ConsentRecordDTO {
    private Long userId;
    private ConsentType consentType;
    private boolean isConsented;
    private String consentVersion;
    private ConsentMethod consentMethod;

}
