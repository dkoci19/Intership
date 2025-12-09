package com.example.rentcar.controller;

import com.example.rentcar.model.Business;
import com.example.rentcar.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping
    public List <Business> getAll(){
        return businessService.getAllBusinesses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Business> getById(@PathVariable Long id) {
        return businessService.getBusinessById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Business create(@RequestBody Business business) {
        return businessService.saveBusiness(business);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Business> update(@PathVariable Long id, @RequestBody Business updatedBusiness) {
        return businessService.getBusinessById(id)
                .map(business -> {
                    business.setName(updatedBusiness.getName());
                    business.setEmail(updatedBusiness.getEmail());
                    business.setPassword(updatedBusiness.getPassword());
                    business.setAddress(updatedBusiness.getAddress());
                    return ResponseEntity.ok(businessService.saveBusiness(business));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id) {
        businessService.deleteBusinessById(id);
        return ResponseEntity.noContent().build();
    }
}
