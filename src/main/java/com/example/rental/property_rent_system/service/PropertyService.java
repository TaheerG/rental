package com.example.rental.property_rent_system.service;

import com.example.rental.property_rent_system.model.Property;
import com.example.rental.property_rent_system.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getProperties() {
        return propertyRepository.findAll();
    }

    public Property getProperties(Long propertyId){
        return propertyRepository.findById(propertyId).orElseThrow(RuntimeException::new);
    }
    public void addNewProperty(Property property) {
        propertyRepository.save(property);
    }

    @Transactional
    public void updateProperty(Long propertyId, double rent){
//        Retrieve the property by ID
        Optional<Property> optionalProperty = propertyRepository.findById(propertyId);

//        check if the property exists, if not throw an exception
        Property property = optionalProperty.orElseThrow(() ->
        new IllegalStateException("Property with id " + propertyId + " does not exist"));

        property.setRent(rent);

        propertyRepository.save(property);
    }
    public void deleteProperty(Long propertyId) {
        boolean exists = propertyRepository.existsById(propertyId);
        if (!exists) {
            throw new IllegalStateException(
                    "tenant with id " + propertyId + " does not exist"
            );
        }
        propertyRepository.deleteById(propertyId);
    }
}
