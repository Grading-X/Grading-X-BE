package com.pytorch.gradingx.domain;

import jakarta.persistence.*;

@Entity
public class CourseMember extends BaseTimeEntity{
    @Id
    @GeneratedValue
    @Column(name = "course_member_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
