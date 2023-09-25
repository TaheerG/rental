package com.example.rental.property_rent_system.model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private int numberOfRooms;
    private double rent;

    public Property() {
    }

    public Property(Long id, String address, int numberOfRooms, double rent) {
        this.id = id;
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.rent = rent;
    }

    public Property(String address, int numberOfRooms, double rent) {
        this.address = address;
        this.numberOfRooms = numberOfRooms;
        this.rent = rent;
    }
    // ... getters and setters ...


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", rent=" + rent +
                '}';
    }
}


