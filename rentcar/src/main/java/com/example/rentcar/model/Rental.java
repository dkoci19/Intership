package com.example.rentcar.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Car car;

    private LocalDate startDate;
    private LocalDate endDate;

    public Rental () {

    }

    public Rental (User user, Car car, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.car = car;
        this.startDate = startDate;
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id=id;
    }

    public User getUser () {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }

    public Car getCar () {
        return car;
    }

    public void setCar (Car car) {
        this.car = car;
    }

    public LocalDate getStartDate () {
        return startDate;
    }

    public void setStartDate (LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate () {
        return endDate;
    }

    public void setEndDate (LocalDate endDate) {
        this.endDate = endDate;
    }
}
