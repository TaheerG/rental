package com.example.rental.property_rent_system.controller;


import com.example.rental.property_rent_system.model.Tenant;
import com.example.rental.property_rent_system.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "/tenants")
public class TenantController {

    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @GetMapping
    public List<Tenant> getAllTenants(){
        return tenantService.getTenants();
    }

    @PostMapping
    public void addTenant(@RequestBody Tenant tenant){
        tenantService.addNewTenant(tenant);
    }

    @PutMapping(path = "{tenantId}")
    public void updateTenant(@PathVariable("tenantId") Long tenantId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email,
                              @RequestParam(required = false) String phone,
                              @RequestParam(required = false) String address){
        tenantService.updateTenant(tenantId, name, email, phone, address);
    }

    @DeleteMapping(path = "{tenantId}")
    public void deleteTenant(@PathVariable("tenantId") Long tenantId){
        tenantService.deleteTenant(tenantId);
    }


}
