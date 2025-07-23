package com.hoo.auth.adapter.out.persistence;

import com.hoo.auth.adapter.out.persistence.repository.BusinessUserCredentialJpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
@EntityScan
public class PersistenceConfig {

    @Bean
    public BusinessUserCredentialJpaAdapter businessUserCredentialJpaAdapter(
            BusinessUserCredentialJpaRepository businessUserCredentialJpaRepository,
            PersistenceMapper persistenceMapper
    ) {
        return new BusinessUserCredentialJpaAdapter(businessUserCredentialJpaRepository, persistenceMapper);
    }

    @Bean
    public PersistenceMapper persistenceMapper() {
        return new PersistenceMapper();
    }
}
