package com.example.mapped.dto;

import lombok.Data;
import com.example.mapped.model.Address;
import com.example.mapped.model.FeeType;
import com.example.mapped.model.ServiceType;
import com.example.mapped.model.InstitutionType;

import java.util.Set;

@Data
public class ServiceProviderDTO {
    private Long id;
    private String name;
    private Address address;
    private String openingHours;
    private Set<FeeType> feeTypes;
    private Set<ServiceType> serviceTypes;
    private InstitutionType institutionType;
    private String phone;
    private String email;
    private String description;
    private Integer capacity;
}