package com.pytorch.gradingx.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Course extends BaseTimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "course_id")
    private Long id;

    private String courseName;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private Member instructor;
}
