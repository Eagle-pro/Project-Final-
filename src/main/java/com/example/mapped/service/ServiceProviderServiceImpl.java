package com.example.mapped.service;

import com.example.mapped.model.ServiceProvider;
import com.example.mapped.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

    private final ServiceProviderRepository serviceProviderRepository;

    @Autowired
    public ServiceProviderServiceImpl(ServiceProviderRepository serviceProviderRepository) {
        this.serviceProviderRepository = serviceProviderRepository;
    }

    @Override
    public Page<ServiceProvider> getAllServiceProviders(Pageable pageable) {
        return serviceProviderRepository.findAll(pageable);
    }

    @Override
    public Optional<ServiceProvider> getServiceProviderById(Long id) {
        return Optional.empty();
    }

    @Override
    public ServiceProvider createServiceProvider(ServiceProvider serviceProvider) {
        return null;
    }

    @Override
    public ServiceProvider updateServiceProvider(Long id, ServiceProvider serviceProvider) {
        return null;
    }

    @Override
    public void deleteServiceProvider(Long id) {

    }

    @Override
    public List<ServiceProvider> searchServiceProviders(String name, String serviceType, String feeType) {
        return List.of();
    }

    // Implement other methods...
}