package com.example.springboot.jpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "tbl_student",
        uniqueConstraints =  @UniqueConstraint(
                columnNames = "email_address"
        ))
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "guardian_name")),
            @AttributeOverride(name = "email", column = @Column(name = "guardian_email")),
            @AttributeOverride(name = "mobile", column = @Column(name = "guardian_mobile"))
    })
    private Guardian guardian;
}
