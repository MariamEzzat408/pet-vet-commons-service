package com.petcare.commons.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.petcare.commons.model.enums.AuthProvider;
import com.petcare.commons.model.enums.PreferredLanguage;
import com.petcare.commons.model.enums.RetentionCategory;
import com.petcare.commons.model.enums.IdentityVerificationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "name_ar")
    private String nameAr;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_Number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "auth_provider", columnDefinition = "ENUM('EMAIL', 'GOOGLE', 'FACEBOOK', 'TWITTER')")
    private AuthProvider authProvider = AuthProvider.EMAIL;

    @Column(name = "auth_id")
    private String authId;

    @Column(name = "isVerified" ,nullable = false)
    private boolean isVerified = false;

    @Column(name = "lastLogin")
    private LocalDateTime lastLogin;

    @Enumerated(EnumType.STRING)
    @Column(name = "preferred_language", columnDefinition = "ENUM('EN', 'AR')")
    private PreferredLanguage preferredLanguage = PreferredLanguage.EN;

    @Column(name = "data_region", columnDefinition = "VARCHAR(50) DEFAULT 'KSA'", nullable = false)
    private String dataRegion ="KSA";


    @Enumerated(EnumType.STRING)
    @Column(name = "retention_category", columnDefinition = "ENUM('STANDARD', 'EXTENDED', 'PERMANENT')")
    private RetentionCategory retentionCategory = RetentionCategory.STANDARD;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "partition_key")
    private String partitionKey;

    @Column(name = "archived" )
    private boolean archived = false;

    @Column(name = "archived_date")
    private LocalDateTime archivedDate;

    @Column(name = "stripe_customer_id")
    private String stripeCustomerId;

    @Column(name = "default_payment_method_id")
    private String defaultPaymentMethodId;

    @Column(name = "payment_methods_count")
    private int paymentMethodsCount=0;

    @Column(name = "consent_version")
    private String consentVersion;

    @Column(name = "last_terms_acceptance")
    private LocalDateTime lastTermsAcceptance;

    @Enumerated(EnumType.STRING)
    @Column(name = "identity_verification_status", columnDefinition = "ENUM('UNVERIFIED', 'PENDING', 'VERIFIED', 'REJECTED')")
    private IdentityVerificationStatus identityVerificationStatus=IdentityVerificationStatus.UNVERIFIED;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "consent_To_DataProcessing")
    private boolean consentToDataProcessing;

    @Column(name = "consent_To_MarketingEmails")
    private boolean consentToMarketingEmails;

    @Column(name="refreshToken")
    private String refreshToken;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles", //Mapping table
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

}