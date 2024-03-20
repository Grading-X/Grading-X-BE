package com.pytorch.gradingx.domain;

import jakarta.persistence.*;

@Entity
public class Question extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    private Integer index;
    private String query;
    private Integer weightage;
}
