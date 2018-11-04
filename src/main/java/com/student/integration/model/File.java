package com.student.integration.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="create_user_id")
    private Long createUserId;

    @Column(name="rating")
    private Long rating;

    @Column(name="rating_count")
    private Long ratingCount;
}
