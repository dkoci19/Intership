package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private StudentRepository studentRepository;

    public final StudentService studentService;
    public MyController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable long id,@RequestBody Student student ){
        Student existingStudent = studentService.getStudentById(id);
        Student existingStudent1 = existingStudent;
        if (existingStudent1 != null){
            existingStudent1.setEmri(student.getEmri());
            return studentService.saveStudent(existingStudent);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Student deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return null;
    }
}
