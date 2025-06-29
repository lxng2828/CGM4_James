package com.codegym.aop_exception_handling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegym.aop_exception_handling.model.BorrowingCode;

import java.util.Optional;

public interface BorrowingCodeRepository extends JpaRepository<BorrowingCode, Long> {
    Optional<BorrowingCode> findByCode(String code);
}