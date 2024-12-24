package com.example.springboot.jpa.tutorial.repository;

import com.example.springboot.jpa.tutorial.entity.Guardian;
import com.example.springboot.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentTest() {
        Student student = Student.builder()
                .firstName("teaMan")
                .lastName("teaMan")
                .emailId("teaMan@yopmail.com")
//                .guardianName("VG")
//                .guardianEmail("vg@yopmail.com")
//                .guardianMobile("9000090000")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getAllStudentsTest() {
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void saveStudentDetailsWithGuardianTest() {
        Guardian guardian = Guardian.builder()
                .name("VG")
                .email("VG@yopmail.com")
                .mobile("9000090000")
                .build();

        Student student = Student.builder()
                .firstName("Rohit")
                .lastName("Sharma")
                .emailId("RS@yopmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
}