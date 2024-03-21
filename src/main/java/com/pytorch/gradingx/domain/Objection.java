package com.pytorch.gradingx.domain;

import jakarta.persistence.*;

@Entity
public class Objection extends BaseTimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "objection_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_email")
    private Guest guest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Lob
    private String content;
}
