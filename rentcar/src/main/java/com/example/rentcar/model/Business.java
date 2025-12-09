package com.example.rentcar.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String name;
    private String email;
    private String password;
    private String address;

    @OneToMany(mappedBy = "business" ,cascade = CascadeType.ALL)
    private List <Car> cars;

    public Business() {

    }

    public Business(String name, String email, String password, String address){
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
