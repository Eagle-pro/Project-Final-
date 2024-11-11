package com.example.mapped.demo;

import com.example.mapped.model.ServiceProvider;
import com.example.mapped.model.Address;
import com.example.mapped.model.FeeType;
import com.example.mapped.model.ServiceType;
import com.example.mapped.model.InstitutionType;
import com.example.mapped.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@Profile("demo")
class ServiceProviderTestData {
    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Bean
    public CommandLineRunner initServiceProviders() {
        return args -> {
            ServiceProvider provider1 = new ServiceProvider();
            provider1.setName("Sample Provider 1");
            provider1.setAddress(new Address("123 Main St", "City1", "State1", "12345"));
            provider1.setOpeningHours("9 AM - 5 PM");
            provider1.setFeeTypes(new HashSet<>(Arrays.asList(FeeType.FIXED, FeeType.HOURLY)));
            provider1.setServiceTypes(new HashSet<>(Arrays.asList(ServiceType.COUNSELING, ServiceType.THERAPY)));
            provider1.setInstitutionType(InstitutionType.PRIVATE);

            ServiceProvider provider2 = new ServiceProvider();
            provider2.setName("Sample Provider 2");
            provider2.setAddress(new Address("456 Elm St", "City2", "State2", "67890"));
            provider2.setOpeningHours("8 AM - 6 PM");
            provider2.setFeeTypes(new HashSet<>(Arrays.asList(FeeType.SLIDING_SCALE)));
            provider2.setServiceTypes(new HashSet<>(Arrays.asList(ServiceType.PSYCHOTHERAPY, ServiceType.GROUP_THERAPY)));
            provider2.setInstitutionType(InstitutionType.PUBLIC);

            serviceProviderRepository.saveAll(Arrays.asList(provider1, provider2));
        };
    }
    }

    // ... (rest of the code remains the same)
