package com.example.rental.property_rent_system.repository;

import com.example.rental.property_rent_system.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, String>{
    Rental findById(Long rentalId);
}
