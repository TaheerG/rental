package com.example.rental.property_rent_system.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenant_id", nullable = true)
    private Tenant tenant;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_id", nullable = true)
    private Property property;
    private LocalDate startDate;
    private LocalDate endDate;
    @Transient
    private BigDecimal rent;

    // Constructors, getters, setters, and other methods

    public Rental() {
    }

    public Rental(Long id, Tenant tenant, Property property, LocalDate startDate, LocalDate endDate, BigDecimal rent) {
        this.id = id;
        this.tenant = tenant;
        this.property = property;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rent = rent;
    }

    public Rental(Tenant tenant, Property property, LocalDate startDate, LocalDate endDate, BigDecimal rent) {
        this.tenant = tenant;
        this.property = property;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rent = rent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getRent() {
        if (property != null && startDate != null && endDate != null) {
            // Calculate the number of years between startDate and endDate
            long numberOfYears = Period.between(this.startDate, this.endDate).getYears();

            // Get the rent amount from the associated Property
            BigDecimal propertyRent = BigDecimal.valueOf(property.getRent());

            // Calculate the total rent
            return propertyRent.multiply(BigDecimal.valueOf(numberOfYears));
        } else {
            return BigDecimal.ZERO; // Handle null values or invalid data as needed
        }
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

//    public static int getCounter() {
//        return counter;
//    }
//
//    public static void setCounter(int counter) {
//        Rental.counter = counter;
//    }

    @Override
    public String toString() {
        return "Rental{" +
                "tenantId=" + (tenant != null ? tenant.getId() : null) +
                ", tenantName=" + (tenant != null ? tenant.getName() : null) +
                ", propertyId=" + (property != null ? property.getId() : null) +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", rent=" + rent +
                '}';
    }

//    // Generate custom IDs
//    public static String generateCustomId() {
//        // Simulated logic to retrieve the next available custom ID from the database
//        int nextId = getNextCustomIdFromDatabase();
//
//        // Format the ID
//        String customId = String.format("R%03d", nextId);
//
//        return customId;
//    }
//
//    // Simulated logic to retrieve the next available custom ID from the database
//    private static int getNextCustomIdFromDatabase() {
//        // In a real application, you would query the database to get the next ID.
//        // For demonstration purposes, we use a counter here.
//        return getNextIdFromCounter();
//    }
//
//    // Simulated counter for demonstration purposes
//    private static int counter = 1;
//
//    // Simulated logic to get the next ID from the counter
//    private static int getNextIdFromCounter() {
//        return counter++;
//    }
}

