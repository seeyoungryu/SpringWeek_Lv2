package com.sparta.book.controller;

import com.sparta.book.dto.BookRequestDto;
import com.sparta.book.dto.BookResponseDto;
import com.sparta.book.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //도서 등록 기능
    @PostMapping("/books")
    public BookResponseDto createBook(@RequestBody BookRequestDto requestDto) {
        return bookService.registerBook(requestDto);
    }
    //선택 도서 목록 조회
    @GetMapping("/books/{id}")
    public BookResponseDto getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }
    //도서 전체 목록 조회
    @GetMapping("/books")
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAllBooks();
    }
}
