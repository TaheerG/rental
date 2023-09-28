package com.example.rental.property_rent_system.service;

import com.example.rental.property_rent_system.dto.RentalRequestDTO;
import com.example.rental.property_rent_system.dto.RentalResponseDTO;
import com.example.rental.property_rent_system.model.Property;
import com.example.rental.property_rent_system.model.Rental;
import com.example.rental.property_rent_system.model.Tenant;
import com.example.rental.property_rent_system.repository.PropertyRepository;
import com.example.rental.property_rent_system.repository.RentalRepository;
import com.example.rental.property_rent_system.repository.TenantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;
    private final TenantRepository tenantRepository;
    private  final PropertyRepository propertyRepository;



    @Autowired
    public RentalService(RentalRepository rentalRepository, TenantRepository tenantRepository, PropertyRepository propertyRepository) {
        this.rentalRepository = rentalRepository;
        this.tenantRepository = tenantRepository;
        this.propertyRepository = propertyRepository;
    }

    public Rental createRental(RentalRequestDTO rentalRequestDTO) {
        Long propertyId = rentalRequestDTO.getPropertyId();
        // Check if property and tenant exist
        Property property = propertyRepository.findById(rentalRequestDTO.getPropertyId())
                .orElseThrow(() -> new EntityNotFoundException("Property not found"));

        Tenant tenant = tenantRepository.findById(rentalRequestDTO.getTenantId())
                .orElseThrow(() -> new EntityNotFoundException("Tenant not found"));

        if (!tenant.getProperty().getId().equals(propertyId)) {
            throw new IllegalStateException("Tenant's property does not match the specified property.");
        }
        // Create a new Rental object
        Rental rental = new Rental();
        rental.setStartDate(rentalRequestDTO.getStartDate());
        rental.setEndDate(rentalRequestDTO.getEndDate());
        rental.setProperty(property);
        rental.setTenant(tenant);

        // Save the rental
        return rentalRepository.save(rental);
    }
//    public void addNewRental(Rental rental) {
//        rentalRepository.save(rental);
//    }

    public List<RentalResponseDTO> getAllRentalsAsDTOs() {
        List<Rental> rentals = rentalRepository.findAll();

        // Convert Rental entities to RentalResponseDTO objects
        List<RentalResponseDTO> rentalDTOs = rentals.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

        return rentalDTOs;
    }

    private RentalResponseDTO mapToDTO(Rental rental) {
        RentalResponseDTO dto = new RentalResponseDTO();
        dto.setId(rental.getId());
        dto.setTenantId(rental.getTenant().getId());
        dto.setName(rental.getTenant().getName());
        dto.setPropertyId(rental.getProperty().getId());
        dto.setStartDate(rental.getStartDate());
        dto.setEndDate(rental.getEndDate());
        dto.setRent(rental.getRent());

        return dto;
    }



    public Rental getRentalById(Long rentalId) {
        return rentalRepository.findById(rentalId);
    }

    public void deleteRental(Long rentalId) {
        boolean exists = rentalRepository.existsById(String.valueOf(rentalId));
        if (!exists) {
            throw new IllegalStateException(
                    "rental with id " + rentalId + " does not exist"
            );
        }
        rentalRepository.deleteById(String.valueOf(rentalId));
    }
}
