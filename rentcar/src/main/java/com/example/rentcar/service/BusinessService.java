package com.example.rentcar.service;

import com.example.rentcar.model.Business;
import com.example.rentcar.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {
    @Autowired
    private BusinessRepository businessRepository;

    public List<Business> getAllBusinesses(){
        return businessRepository.findAll();
    }

    public Optional <Business> getBusinessById(Long id) {
        return businessRepository.findById(id);
    }

    public Business saveBusiness(Business business) {
        return businessRepository.save(business);
    }

    public void deleteBusinessById(Long id) {
        businessRepository.deleteById(id);
    }
}
