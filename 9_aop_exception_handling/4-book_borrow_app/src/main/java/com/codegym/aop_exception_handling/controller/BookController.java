package com.codegym.aop_exception_handling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codegym.aop_exception_handling.exception.OutOfStockException;
import com.codegym.aop_exception_handling.model.Book;
import com.codegym.aop_exception_handling.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String showBookList(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "list";
    }

    @GetMapping("/view/{id}")
    public String showBookDetail(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        if (book == null) {
            return "redirect:/";
        }
        model.addAttribute("book", book);
        return "view";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Long bookId, RedirectAttributes redirectAttributes)
            throws OutOfStockException {
        String code = bookService.borrowBook(bookId);
        redirectAttributes.addFlashAttribute("message", "Mượn sách thành công! Mã mượn của bạn là: " + code);
        return "redirect:/";
    }

    @GetMapping("/return")
    public String showReturnForm() {
        return "return-form";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String code, RedirectAttributes redirectAttributes) throws Exception {
        bookService.returnBook(code);
        redirectAttributes.addFlashAttribute("message", "Trả sách thành công! Cảm ơn bạn.");
        return "redirect:/";
    }
}