package com.example.rentcar.controller;

import com.example.rentcar.model.Rental;
import com.example.rentcar.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping
    public List<Rental> getAll() {
        return rentalService.findAllRentals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rental> getById(@PathVariable Long id) {
        return rentalService.findRentalsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rental create(@RequestBody Rental rental) {
        return rentalService.saveRental(rental);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rental> update(@PathVariable Long id, @RequestBody Rental updatedRental) {
        return rentalService.findRentalsById(id)
                .map(rental -> {
                    rental.setUser(updatedRental.getUser());
                    rental.setCar(updatedRental.getCar());
                    rental.setStartDate(updatedRental.getStartDate());
                    rental.setEndDate(updatedRental.getEndDate());
                    return ResponseEntity.ok(rentalService.saveRental(rental));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rentalService.deleteRental(id);
        return ResponseEntity.noContent().build();
    }
}
