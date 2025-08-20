package com.petcare.commons.model.dto;

import com.petcare.commons.model.enums.AddressType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressUpdateDTO {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private AddressType addressType;
    private boolean isDefault;
    private Double latitude;
    private Double longitude;

}
