package com.petcare.commons.model.entity;

import com.petcare.commons.model.enums.AddressType;
import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "addressID")
    private Long id;

    @Column(name = "userID", nullable = false)
    private Long userID;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipCode", length = 20)
    private String zipCode;

    @Column(name = "country", columnDefinition = "VARCHAR(100) DEFAULT 'Saudi Arabia'")
    private String country = "Saudi Arabia";

    @Enumerated(EnumType.STRING)
    @Column(name = "address_type")
    private AddressType addressType = AddressType.HOME;

    @Column(name = "isDefault")
    private boolean isDefault = false;

    @Column(name = "is_verified")
    private boolean isVerified = false; // Default value in Java

    @Column(name = "verification_method")
    private String verificationMethod;

    @Column(name = "verification_date")
    private LocalDateTime verificationDate;

//    @ManyToOne
//    @JoinColumn(name = "verified_by", foreignKey = @ForeignKey(name = "FK_VERIFIED_BY_USER"))
//    private User verifiedBy;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;


}
