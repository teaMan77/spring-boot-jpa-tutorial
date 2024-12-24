package com.example.springboot.jpa.tutorial.repository;

import com.example.springboot.jpa.tutorial.entity.Course;
import com.example.springboot.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course course = Course.builder()
                .title("CO")
                .credit(4)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Virat")
                .lastName("Singh")
                .courses(List.of(course))
                .build();

        teacherRepository.save(teacher);
    }
}