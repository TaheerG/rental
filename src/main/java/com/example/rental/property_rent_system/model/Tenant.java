package com.example.rental.property_rent_system.model;

import jakarta.persistence.*;


@Entity
@Table
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_id", nullable = true)

    private Property property;

    public Tenant() {
    }

    public Tenant(Long id, String name, String email, String phone, String address, Property property) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.property = property;
    }

    public Tenant(String name, String email, String phone, String address, Property property) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.property = property;
    }

    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", property=" + property +
                '}';
    }

}
