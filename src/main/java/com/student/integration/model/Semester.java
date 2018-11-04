package com.student.integration.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "university_semesters")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="semester_name")
    private String semesterName;
}
