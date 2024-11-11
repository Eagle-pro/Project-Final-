package com.example.mapped.controller;

import com.example.mapped.model.ServiceProvider;
import com.example.mapped.service.ServiceProviderService;
import com.example.mapped.dto.ServiceProviderDTO;
import com.example.mapped.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/service-providers")
public class ServiceProviderController {

    private final ServiceProviderService serviceProviderService;

    @Autowired
    public ServiceProviderController(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    @GetMapping
    public ResponseEntity<Page<ServiceProviderDTO>> getAllServiceProviders(Pageable pageable) {
        Page<ServiceProvider> providers = serviceProviderService.getAllServiceProviders(pageable);
        Page<ServiceProviderDTO> dtos = providers.map(this::convertToDTO);
        return ResponseEntity.ok(dtos);
      }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceProviderDTO> getServiceProviderById(@PathVariable Long id) {
        return serviceProviderService.getServiceProviderById(id)
                .map(this::convertToDTO)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("ServiceProvider not found with id: " + id));
    }

    @PostMapping
    public ResponseEntity<ServiceProviderDTO> createServiceProvider(@Valid @RequestBody ServiceProviderDTO serviceProviderDTO) {
        ServiceProvider serviceProvider = convertToEntity(serviceProviderDTO);
        ServiceProvider createdProvider = serviceProviderService.createServiceProvider(serviceProvider);
        return new ResponseEntity<>(convertToDTO(createdProvider), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceProviderDTO> updateServiceProvider(@PathVariable Long id, @Valid @RequestBody ServiceProviderDTO serviceProviderDTO) {
        ServiceProvider serviceProvider = convertToEntity(serviceProviderDTO);
        ServiceProvider updatedProvider = serviceProviderService.updateServiceProvider(id, serviceProvider);
        return ResponseEntity.ok(convertToDTO(updatedProvider));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServiceProvider(@PathVariable Long id) {
        serviceProviderService.deleteServiceProvider(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<ServiceProviderDTO>> searchServiceProviders(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String serviceType,
            @RequestParam(required = false) String feeType) {
        List<ServiceProvider> providers = serviceProviderService.searchServiceProviders(name, serviceType, feeType);
        List<ServiceProviderDTO> dtos = providers.stream().map(this::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    private ServiceProviderDTO convertToDTO(ServiceProvider serviceProvider) {
        // Implement the conversion logic from ServiceProvider to ServiceProviderDTO
        // This is a placeholder and should be replaced with actual implementation
        return new ServiceProviderDTO();
    }

    private ServiceProvider convertToEntity(ServiceProviderDTO dto) {
        // Implement the conversion logic from ServiceProviderDTO to ServiceProvider
        // This is a placeholder and should be replaced with actual implementation
        return new ServiceProvider();
    }
}