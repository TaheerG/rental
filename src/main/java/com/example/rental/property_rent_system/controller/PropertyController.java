package com.example.rental.property_rent_system.controller;

import com.example.rental.property_rent_system.model.Property;
import com.example.rental.property_rent_system.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/properties")
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }
    @GetMapping
    public List<Property> getAllProperties() {
        return propertyService.getProperties();
    }

    @GetMapping(path = "{propertyId}")
    public Property getProperty(@PathVariable Long propertyId) {
        return propertyService.getProperties(propertyId);
    }

    @PostMapping
    public void createProperty(@RequestBody Property property) {
         propertyService.addNewProperty(property);
    }

    @PutMapping(path = "{propertyId}")
    public void updateProperty(@PathVariable("propertyId") Long propertyId,
                               @RequestParam(required = false) double rent){
        propertyService.updateProperty(propertyId,rent);
    }

    @DeleteMapping(path = "{propertyId}")
    public void deleteProperty(@PathVariable("propertyId") Long propertyId){
        propertyService.deleteProperty(propertyId);
    }
}

