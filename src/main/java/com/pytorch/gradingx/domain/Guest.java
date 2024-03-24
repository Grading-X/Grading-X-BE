package com.pytorch.gradingx.domain;

import jakarta.persistence.*;

@Entity
public class Guest extends BaseTimeEntity{
    @Id
    @Column(name = "guest_email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_content_id")
    private ExamContent examContent;
}
