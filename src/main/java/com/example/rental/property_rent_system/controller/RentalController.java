package com.example.rental.property_rent_system.controller;

import com.example.rental.property_rent_system.dto.RentalRequestDTO;
import com.example.rental.property_rent_system.dto.RentalResponseDTO;
import com.example.rental.property_rent_system.model.Rental;
import com.example.rental.property_rent_system.model.Tenant;
import com.example.rental.property_rent_system.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rentals")
public class RentalController {

    private final RentalService rentalService;

    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    public ResponseEntity<Rental> createRental(@RequestBody RentalRequestDTO rentalRequestDTO) {
        Rental createdRental = rentalService.createRental(rentalRequestDTO);
        return new ResponseEntity<>(createdRental, HttpStatus.CREATED);
    }

    @GetMapping
    public List<RentalResponseDTO> getAllRentals() {
        List<RentalResponseDTO> rentals = rentalService.getAllRentalsAsDTOs();
        return rentals;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalResponseDTO> getRentalById(@PathVariable Long id) {
        Rental rental = rentalService.getRentalById(id);

        // Create a RentalResponseDTO instance and set the desired fields
        RentalResponseDTO responseDTO = new RentalResponseDTO();
        responseDTO.setId(rental.getId());
        responseDTO.setTenantId(rental.getTenant().getId());
        responseDTO.setName(rental.getTenant().getName());
        responseDTO.setPropertyId(rental.getProperty().getId());
        responseDTO.setStartDate(rental.getStartDate());
        responseDTO.setEndDate(rental.getEndDate());
        responseDTO.setRent(rental.getRent());

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping(path = "{rentalId}")
    public void deleteRental(@PathVariable("rentalId") Long rentalId){
        rentalService.deleteRental(rentalId);
    }
}
