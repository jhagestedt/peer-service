package com.example.service.discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistration;
import org.springframework.cloud.client.serviceregistry.AutoServiceRegistrationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

import javax.annotation.PostConstruct;

@Configuration
@Import(AutoMultiServiceRegistrationConfiguration.class)
@ConditionalOnProperty(value = "spring.cloud.service-registry.auto-multi-registration.enabled", havingValue = "true")
public class AutoMultiServiceRegistrationAutoConfiguration {

    @Autowired(required = false)
    private List<AutoServiceRegistration> autoServiceRegistrations;

    @Autowired
    private AutoServiceRegistrationProperties properties;

    @PostConstruct
    protected void init() {
        if ((autoServiceRegistrations == null || autoServiceRegistrations.isEmpty()) && this.properties.isFailFast()) {
            throw new IllegalStateException("Auto Multi Service Registration has been requested, but there is no AutoServiceRegistration bean");
        }
    }
}