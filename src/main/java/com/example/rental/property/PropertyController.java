package com.example.rental.property;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropertyController {

    private final PropertyRepository propertyRepository;

    public PropertyController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @GetMapping("/properties")
    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    @PostMapping("/properties")
    public Property createProperty(@RequestBody Property property) {
        return propertyRepository.save(property);
    }

    // ... other methods ...
}

