package com.student.integration.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "academies")
public class Academy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="academy_name")
    private String academyName;

    @Column(name="academy_name_short")
    private String academyNameShort;

    //@OneToMany(mappedBy="cart")
    //private Set<Subject> subjects;
}
