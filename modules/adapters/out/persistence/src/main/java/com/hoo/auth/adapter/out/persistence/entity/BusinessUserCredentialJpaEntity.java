package com.hoo.auth.adapter.out.persistence.entity;

import com.hoo.auth.domain.BusinessUserCredential;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BUSINESS_USER_CREDENTIAL")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessUserCredentialJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String encryptedPassword;

    public static BusinessUserCredentialJpaEntity createNewEntity(BusinessUserCredential businessUserCredential) {
        return new BusinessUserCredentialJpaEntity(
                null,
                businessUserCredential.getEmail(),
                businessUserCredential.getEncryptedPassword()
        );
    }
}
