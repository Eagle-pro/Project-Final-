package com.example.mapped.service;

import com.example.mapped.model.ServiceProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ServiceProviderService {
    Page<ServiceProvider> getAllServiceProviders(Pageable pageable);
    Optional<ServiceProvider> getServiceProviderById(Long id);
    ServiceProvider createServiceProvider(ServiceProvider serviceProvider);
    ServiceProvider updateServiceProvider(Long id, ServiceProvider serviceProvider);
    void deleteServiceProvider(Long id);
    List<ServiceProvider> searchServiceProviders(String name, String serviceType, String feeType);
}