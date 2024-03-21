package com.pytorch.gradingx.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Assignment extends BaseTimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "assignment_id")
    private Long id;

    private String assignName;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

}
