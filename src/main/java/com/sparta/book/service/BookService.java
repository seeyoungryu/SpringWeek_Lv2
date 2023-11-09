package com.sparta.book.service;

import com.sparta.book.dto.BookRequestDto;
import com.sparta.book.dto.BookResponseDto;
import com.sparta.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // 도서 등록
    public BookResponseDto registerBook(BookRequestDto requestDto) {
        Book book = new Book();
        bookRepository.save(book);
        return new BookResponseDto(book);
    }
    // 모든 도서 조회
    public List<BookResponseDto> getAllBooks() {
        List<Book> books = bookRepository.findAllByOrderByRegisteredDateAsc();
        return books.stream().map(BookResponseDto::new).collect(Collectors.toList());
    }
    //선택 도서 조회
    public BookResponseDto getBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("책을 찾지 못했습니다."));
        return new BookResponseDto(book);
    }
}
