package com.example.springboot.jpa.tutorial.repository;

import com.example.springboot.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String str);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    Student findByGuardianName(String guardianName);

    //JPQL
    @Query("Select s from Student s where s.emailId = ?1")
    Student findByEmailAddress(String emailId);

    @Query("Select s from Student s where s.firstName = ?1 and s.guardian.name = ?2")
    List<Student> findByFirstNameAndGuardianName(String firstName, String guardianName);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String findFirstNameByEmailId(String emailId);
}
