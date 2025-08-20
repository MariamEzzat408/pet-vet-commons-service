package com.petcare.commons.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationResponseDTO {
    private boolean isValid;
    private String message;

}
