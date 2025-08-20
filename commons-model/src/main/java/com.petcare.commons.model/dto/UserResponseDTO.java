package com.petcare.commons.model.dto;

import com.petcare.commons.model.enums.PreferredLanguage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private Long id;
    private String email;
    private String name;
    private String nameAr;
    private String phone;
    private PreferredLanguage preferredLanguage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PreferredLanguage getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(PreferredLanguage preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }
}
