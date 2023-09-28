package com.example.rental.property_rent_system.repository;

import com.example.rental.property_rent_system.model.Property;
import com.example.rental.property_rent_system.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    @Query("SELECT t FROM Tenant t WHERE t.email =?1")
    Optional<Tenant> findTenantByEmail(String email);

    boolean existsByProperty(Property property);
}
