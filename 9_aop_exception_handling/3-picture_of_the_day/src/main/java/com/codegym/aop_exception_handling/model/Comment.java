package com.codegym.aop_exception_handling.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rating;
    private String author;
    @Column(columnDefinition = "TEXT")
    private String feedback;
    private int likes = 0;
}