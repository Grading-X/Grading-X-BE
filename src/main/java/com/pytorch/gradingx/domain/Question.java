package com.pytorch.gradingx.domain;

import jakarta.persistence.*;

@Entity
public class Question extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_content_id")
    private ExamContent examContent;

    private Integer index;
    private String query;
    private Integer weightage;
}
