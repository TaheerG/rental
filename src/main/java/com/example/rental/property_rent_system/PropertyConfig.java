//this is for the start of app
//it is commented after the first ru to avoid having repition of data into the database
//------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------
//package com.example.rental.property;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.*;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class PropertyConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(PropertyRepository repository) {
//        return args -> {
//            Property house1 = new Property(
//                    "123 Gimbiya Street",
//                    3,
//                    1500000.00
//            );
//
//            Property house2 = new Property(
//                    "456 Sokoto Street",
//                    2,
//                    1000000.00
//            );
//
//            repository.saveAll(
//                    List.of(house1, house2)
//            );
//        };
//    }
//}
