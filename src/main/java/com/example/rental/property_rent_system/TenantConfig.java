//package com.example.rental.property_rent_system;
//
//import com.example.rental.property_rent_system.model.Property;
//import com.example.rental.property_rent_system.model.Tenant;
//import com.example.rental.property_rent_system.repository.PropertyRepository;
//import com.example.rental.property_rent_system.repository.TenantRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//import java.util.Optional;
//
//@Configuration
//public class TenantConfig {
//
//
//    @Bean
//    CommandLineRunner commandLineRunner(TenantRepository tenantRepository, PropertyRepository propertyRepository) {
//        return args -> {
//            // Get the Property object from the database.
//            Optional<Property> property = propertyRepository.findById(3L);
//
//            // Check if the Optional object has a value.
//            if (property.isPresent()) {
////                 Get the Property object from the Optional object.
//                Property propertyObject = property.get();
//
//                // Create a new Tenant object and set the property field to the Property object that we retrieved from the database.
//                Tenant tenant = new Tenant(
//                        "Tahir Goni",
//                        "tahir@gmail.com",
//                        "809-465-3333",
//                        "B12 street",
//                        propertyObject
//                );
//
//                // Save the Tenant object to the database.
//                tenantRepository.save(tenant);
//            } else {
//                // The Property object does not exist.
//                System.out.println("The Property object with the ID 1L does not exist.");
//            }
//        };
//    }
//
//
//}
