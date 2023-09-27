package com.example.rental.property_rent_system.service;

import com.example.rental.property_rent_system.model.Property;
import com.example.rental.property_rent_system.model.Tenant;
import com.example.rental.property_rent_system.repository.PropertyRepository;
import com.example.rental.property_rent_system.repository.TenantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TenantService {

    private final TenantRepository tenantRepository;
    private final PropertyRepository propertyRepository;

    @Autowired
    public TenantService(TenantRepository tenantRepository, PropertyRepository propertyRepository, PropertyRepository propertyRepository1) {
        this.tenantRepository = tenantRepository;
        this.propertyRepository = propertyRepository1;
    }

    public List<Tenant> getTenants() {
        return tenantRepository.findAll();
    }


    public void addNewTenant(Tenant tenant) {

        String propertyAddress = tenant.getProperty() != null ? tenant.getProperty().getAddress() : null;
        tenantRepository.save(tenant);
    }

    @Transactional
    public void updateTenant(Long tenantId, String name, String email, String phone, String address) {
        // Retrieve the student by ID
        Optional<Tenant> optionalStudent = tenantRepository.findById(tenantId);

        // Check if the tenant exists; if not, throw an exception
        Tenant tenant = optionalStudent.orElseThrow(() ->
                new IllegalStateException("Student with id " + tenantId + " does not exist"));

        // Update the tenant's name if it is not null, not empty, and different from the current name
        if (name != null && !name.isEmpty() && !Objects.equals(tenant.getName(), name)) {
            tenant.setName(name);
        }

        // Additional logic for updating the email if needed
        if (email != null && !email.isEmpty() && !Objects.equals(tenant.getEmail(), email)) {
            Optional<Tenant> studentOptional = tenantRepository.findTenantByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            tenant.setEmail(email);
        }
        tenant.setPhone(phone);
        tenant.setAddress(address);

        // Save the updated tenant object back to the database
        tenantRepository.save(tenant);

    }

    public void deleteTenant(Long tenantId) {
        boolean exists = tenantRepository.existsById(tenantId);
        if (!exists) {
            throw new IllegalStateException(
                    "tenant with id " + tenantId + " does not exist"
            );
        }
        tenantRepository.deleteById(tenantId);
    }
}
