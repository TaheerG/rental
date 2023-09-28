//package com.example.rental.property_rent_system.configuration;
//
//import com.example.rental.property_rent_system.model.Property;
//import com.example.rental.property_rent_system.model.Rental;
//import com.example.rental.property_rent_system.model.Tenant;
//import com.example.rental.property_rent_system.repository.PropertyRepository;
//import com.example.rental.property_rent_system.repository.RentalRepository;
//import com.example.rental.property_rent_system.repository.TenantRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.List;
//
//@Configuration
//public class RentalConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(RentalRepository repository, TenantRepository tenantRepository, PropertyRepository propertyRepository) {
//        return args -> {
//            // Fetch the Tenant and Property objects based on your requirements
//            Tenant tenantId = tenantRepository.findById(1L).orElse(null); // Replace 1L with the actual tenant ID
//            Property propertyId = propertyRepository.findById(1L).orElse(null); // Replace 1L with the actual property ID
//
//            if (tenantId != null && propertyId != null) {
//                // Now, you can create the Rental object using the extracted IDs
//
//                Rental first = new Rental(
//                        tenantId,
//                        propertyId,
//                        LocalDate.of(2021, Month.JULY, 10),
//                        LocalDate.of(2024, Month.JULY, 10)
//                );
//
//                repository.save(first);
//            }
//        };
//    }
//}
