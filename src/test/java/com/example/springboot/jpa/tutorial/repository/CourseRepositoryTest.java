package com.example.springboot.jpa.tutorial.repository;

import com.example.springboot.jpa.tutorial.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getCoursesWithPage() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);

        Pageable secondPageWithTwoRecords =
                PageRequest.of(1, 2);

        List<Course> coursesOnFirstPage = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        List<Course> coursesOnSecondPage = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        System.out.println("coursesOnFirstPage = " + coursesOnFirstPage);
        System.out.println("coursesOnSecondPage = " + coursesOnSecondPage);
    }

    @Test
    public void getCoursesWithSortedPage() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3, Sort.by("title").descending());

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        System.out.println("courses = " + courses);
    }
}