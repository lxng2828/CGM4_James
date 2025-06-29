package com.codegym.aop_exception_handling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codegym.aop_exception_handling.exception.InvalidCodeException;
import com.codegym.aop_exception_handling.exception.OutOfStockException;
import com.codegym.aop_exception_handling.model.Book;
import com.codegym.aop_exception_handling.model.BorrowingCode;
import com.codegym.aop_exception_handling.repository.BookRepository;
import com.codegym.aop_exception_handling.repository.BorrowingCodeRepository;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowingCodeRepository borrowingCodeRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Transactional(rollbackFor = OutOfStockException.class)
    public String borrowBook(Long id) throws OutOfStockException {
        Book book = findById(id);
        if (book == null || book.getQuantity() == 0) {
            throw new OutOfStockException("Sách đã hết, vui lòng quay lại sau.");
        }

        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        String randomCode = String.valueOf(ThreadLocalRandom.current().nextInt(10000, 100000));
        BorrowingCode borrowingCode = new BorrowingCode(randomCode, book);
        borrowingCodeRepository.save(borrowingCode);

        return randomCode;
    }

    @Transactional(rollbackFor = InvalidCodeException.class)
    public void returnBook(String code) throws InvalidCodeException {
        BorrowingCode borrowingCode = borrowingCodeRepository.findByCode(code)
                .orElseThrow(() -> new InvalidCodeException("Mã mượn sách không hợp lệ."));

        Book book = borrowingCode.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);

        borrowingCodeRepository.delete(borrowingCode);
    }
}