package com.dmset.dragonforge.controllers;

import com.dmset.dragonforge.dtos.BookRecordDto;
import com.dmset.dragonforge.models.BookModel;
import com.dmset.dragonforge.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

     @PostMapping
    public ResponseEntity<BookModel> savebook(@RequestBody BookRecordDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(dto));

    }
}
