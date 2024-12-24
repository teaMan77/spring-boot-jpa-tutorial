package com.example.springboot.jpa.tutorial.repository;

import com.example.springboot.jpa.tutorial.entity.Course;
import com.example.springboot.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourseMaterialTest() {
        Course course = Course.builder()
                .title("Java")
                .credit(5)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void getCourseMaterials() {
        List<CourseMaterial> list = courseMaterialRepository.findAll();

        System.out.println(list);
    }

    @Test
    public void getCourses() {
        List<Course> list = courseRepository.findAll();

        System.out.println("list = " + list);
    }
}