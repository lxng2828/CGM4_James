package com.codegym.aop_exception_handling.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BorrowingCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    @OneToOne 
    @JoinColumn(name = "book_id")
    private Book book;

    public BorrowingCode(String code, Book book) {
        this.code = code;
        this.book = book;
    }
}