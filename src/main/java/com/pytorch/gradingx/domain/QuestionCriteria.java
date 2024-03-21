package com.pytorch.gradingx.domain;

import jakarta.persistence.*;

@Entity
public class QuestionCriteria extends BaseTimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "question_criteria_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Lob
    private String answerList;

    @Lob
    private String keywordList;
}
