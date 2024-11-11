package com.example.mapped.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "service_providers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private String openingHours;

    @ElementCollection
    @CollectionTable(name = "provider_fee_types", joinColumns = @JoinColumn(name = "provider_id"))
    @Enumerated(EnumType.STRING)
    private Set<FeeType> feeTypes;

    @ElementCollection
    @CollectionTable(name = "provider_service_types", joinColumns = @JoinColumn(name = "provider_id"))
    @Enumerated(EnumType.STRING)
    private Set<ServiceType> serviceTypes;

    @Enumerated(EnumType.STRING)
    private InstitutionType institutionType;
}