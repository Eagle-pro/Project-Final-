package com.example.mapped.demo;

import com.example.mapped.model.*;
import com.example.mapped.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@Profile("demo")
public class DemoDataLoader {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Bean
    public CommandLineRunner loadDemoData() {
        return args -> {
            loadClients();
            loadServiceProviders();
            System.out.println("Demo data loaded successfully!");
        };
    }

    private void loadClients() {
        Client client1 = new Client();
        client1.setFullName("Alice Johnson");
        client1.setEmail("alice@example.com");
        client1.setPhoneNumber("123-456-7890");
        client1.setResidenceAddress(new Address("123 Main St", "Cityville", "Stateland", "12345"));
        client1.setDesiredServices(new HashSet<>(Arrays.asList(ServiceType.COUNSELING, ServiceType.THERAPY)));

        Client client2 = new Client();
        client2.setFullName("Bob Smith");
        client2.setEmail("bob@example.com");
        client2.setPhoneNumber("987-654-3210");
        client2.setResidenceAddress(new Address("456 Elm St", "Townsburg", "Provinceland", "67890"));
        client2.setDesiredServices(new HashSet<>(Arrays.asList(ServiceType.THERAPY, ServiceType.GROUP_THERAPY)));

        Client client3 = new Client();
        client3.setFullName("Carol Davis");
        client3.setEmail("carol@example.com");
        client3.setPhoneNumber("555-123-4567");
        client3.setResidenceAddress(new Address("789 Oak Ave", "Villageton", "Countrystate", "13579"));
        client3.setDesiredServices(new HashSet<>(Arrays.asList(ServiceType.COUNSELING, ServiceType.THERAPY)));

        clientRepository.saveAll(Arrays.asList(client1, client2, client3));
    }

    private void loadServiceProviders() {
        ServiceProvider provider1 = new ServiceProvider();
        provider1.setName("Wellness Center");
        provider1.setAddress(new Address("100 Health St", "Medicity", "Carestate", "54321"));
        provider1.setOpeningHours("9 AM - 5 PM");
        provider1.setFeeTypes(new HashSet<>(Arrays.asList(FeeType.FIXED, FeeType.HOURLY)));
        provider1.setServiceTypes(new HashSet<>(Arrays.asList(ServiceType.COUNSELING, ServiceType.THERAPY)));
        provider1.setInstitutionType(InstitutionType.PRIVATE);
        provider1.setPhone("555-123-4567");
        provider1.setEmail("info@wellnesscenter.com");
        provider1.setDescription("Comprehensive mental health services");
        provider1.setCapacity(50);

        ServiceProvider provider2 = new ServiceProvider();
        provider2.setName("Community Health Clinic");
        provider2.setAddress(new Address("200 Care Ave", "Helptown", "Supportstate", "98765"));
        provider2.setOpeningHours("8 AM - 8 PM");
        provider2.setFeeTypes(new HashSet<>(Arrays.asList(FeeType.SLIDING_SCALE)));
        provider2.setServiceTypes(new HashSet<>(Arrays.asList(ServiceType.THERAPY, ServiceType.GROUP_THERAPY)));
        provider2.setInstitutionType(InstitutionType.PUBLIC);
        provider2.setPhone("555-987-6543");
        provider2.setEmail("contact@communityhealthclinic.org");
        provider2.setDescription("Affordable mental health care for all");
        provider2.setCapacity(100);

        serviceProviderRepository.saveAll(Arrays.asList(provider1, provider2));
    }
}