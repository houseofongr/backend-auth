package com.hoo.auth.adapter.out.persistence;

import com.hoo.auth.adapter.out.persistence.config.HibernateCustomNamingStrategy;
import com.hoo.auth.adapter.out.persistence.repository.BusinessUserCredentialJpaRepository;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
@EntityScan
public class PersistenceConfig {

    @Bean
    public JpaCommandAdapter businessUserCredentialJpaAdapter(
            BusinessUserCredentialJpaRepository businessUserCredentialJpaRepository,
            PersistenceMapper persistenceMapper
    ) {
        return new JpaCommandAdapter(businessUserCredentialJpaRepository, persistenceMapper);
    }

    @Bean
    public PersistenceMapper persistenceMapper() {
        return new PersistenceMapper();
    }

    @Bean
    public PhysicalNamingStrategy physicalNamingStrategy() {
        return new HibernateCustomNamingStrategy();
    }
}
