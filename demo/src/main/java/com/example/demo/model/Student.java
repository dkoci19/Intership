package com.example.demo.model;

import jakarta.persistence.*;
@Entity

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long student_id;
    private String emri;

    public long getStudent_idt() {
        return student_id;
    }
    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }
}
