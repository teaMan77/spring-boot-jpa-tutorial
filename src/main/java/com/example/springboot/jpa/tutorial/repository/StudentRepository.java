package com.example.springboot.jpa.tutorial.repository;

import com.example.springboot.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String str);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    Student findByGuardianName(String guardianName);
}
