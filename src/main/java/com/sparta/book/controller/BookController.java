package com.sparta.book.controller;

import com.sparta.book.dto.BookRequestDto;
import com.sparta.book.dto.BookResponseDto;
import com.sparta.book.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 해당 클래스가 REST API의 컨트롤러임을 명시
@RequestMapping("/api") // 해당 컨트롤러의 기본 URL 경로 지정

public class BookController {
    private final BookService bookService; // BookService 클래스를 주입받는 멤버변수

    public BookController(BookService bookService) {
        this.bookService = bookService; // BookService의 주입받은 객체를 할당
    }

    // 도서 등록 기능
    @PostMapping("/books") // POST 요청을 처리하는 API 엔드포인트 지정
    public BookResponseDto createBook(@RequestBody BookRequestDto requestDto) {
        return bookService.registerBook(requestDto); // BookService를 이용해 도서 등록 기능 실행
    }

    // 선택 도서 목록 조회
    @GetMapping("/books/{id}") // GET 요청을 처리하는 API 엔드포인트 지정. {id}는 경로 변수로 사용
    public BookResponseDto getBook(@PathVariable Long id) {
        return bookService.getBook(id); // BookService를 이용해 특정 도서 조회 기능 실행
    }

    // 도서 전체 목록 조회
    @GetMapping("/books") // GET 요청을 처리하는 API 엔드포인트 지정
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAllBooks(); // BookService를 이용해 전체 도서 목록 조회 기능 실행
    }
}
