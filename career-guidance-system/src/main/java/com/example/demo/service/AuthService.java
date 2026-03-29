package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final StudentRepository studentRepository;

    public AuthService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student register(Student student) {

        Student existing = studentRepository.findByEmail(student.getEmail());

        if (existing != null) {
            throw new RuntimeException("Email already exists");
        }

        return studentRepository.save(student);
    }

    public Student login(String email, String password) {

        Student student = studentRepository.findByEmail(email);

        if (student == null) {
            throw new RuntimeException("User not found");
        }

        if (!student.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return student;
    }
}