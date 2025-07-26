package com.hoo.auth.adapter.out.persistence;

import com.hoo.auth.adapter.out.persistence.entity.BusinessUserCredentialJpaEntity;
import com.hoo.auth.adapter.out.persistence.repository.BusinessUserCredentialJpaRepository;
import com.hoo.auth.api.out.SaveBusinessUserCredentialPort;
import com.hoo.auth.domain.BusinessUserCredential;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaCommandAdapter implements SaveBusinessUserCredentialPort {

    private final BusinessUserCredentialJpaRepository businessUserCredentialJpaRepository;
    private final PersistenceMapper persistenceMapper;

    @Override
    public void saveBusinessUserCredential(BusinessUserCredential businessUserCredential) {

        BusinessUserCredentialJpaEntity businessUserCredentialJpaEntity = BusinessUserCredentialJpaEntity.createNewEntity(businessUserCredential);
        businessUserCredentialJpaRepository.save(businessUserCredentialJpaEntity);
    }
}
