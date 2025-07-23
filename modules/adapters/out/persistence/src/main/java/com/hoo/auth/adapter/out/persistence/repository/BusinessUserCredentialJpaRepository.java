package com.hoo.auth.adapter.out.persistence.repository;

import com.hoo.auth.adapter.out.persistence.entity.BusinessUserCredentialJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessUserCredentialJpaRepository extends JpaRepository<BusinessUserCredentialJpaEntity, Long> {
}
