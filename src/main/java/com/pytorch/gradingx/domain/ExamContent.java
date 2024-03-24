package com.pytorch.gradingx.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ExamContent extends BaseTimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "exam_content_id")
    private Long id;

    private String examName;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

}
