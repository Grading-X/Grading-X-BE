package com.pytorch.gradingx.domain;

import jakarta.persistence.*;

@Entity
public class MemberAnswer extends BaseTimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "member_answer_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Lob
    private String answer;

    private Integer score;
}
