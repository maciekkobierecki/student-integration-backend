package com.student.integration.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "university_subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="subject_name")
    private String subjectName;

    @Column(name="display_name")
    private String displayName;

    @Column(name="display_name_short")
    private String displayNameShort;

    @Column(name="id")
    private Long academyId;
}
