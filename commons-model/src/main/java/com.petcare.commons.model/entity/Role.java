package com.petcare.commons.model.entity;
import com.petcare.commons.model.enums.RoleName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false , columnDefinition = "ENUM('USER','SUPPORT_ADMIN','SYSTEM_ADMIN', 'SUPER_ADMIN', 'CLINIC_STAFF')")
    private RoleName roleName=RoleName.USER;



}
