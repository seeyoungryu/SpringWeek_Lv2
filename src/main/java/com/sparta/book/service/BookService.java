package com.sparta.book.service;

import com.sparta.book.dto.BookRequestDto;
import com.sparta.book.dto.BookResponseDto;
import com.sparta.book.entity.Book;
import com.sparta.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
// BookService: 도서 관련 비즈니스 로직을 처리하는 서비스 클래스
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 도서 등록 메서드
    public BookResponseDto registerBook(BookRequestDto requestDto) {
        // 새 Book 객체를 생성하여 저장소에 저장
        Book book = new Book();
        bookRepository.save(book);
        // 새로운 BookResponseDto로 반환
        return new BookResponseDto(book);
    }

    // 모든 도서 조회 메서드
    public List<BookResponseDto> getAllBooks() {
        // 등록일을 기준으로 정렬된 모든 도서 리스트를 가져옴
        List<Book> books = bookRepository.findAllByOrderByRegisteredDateAsc();
        // Book 엔티티 리스트를 BookResponseDto 리스트로 변환하여 반환
        return books.stream().map(BookResponseDto::new).collect(Collectors.toList());
    }

    // 선택 도서 조회 메서드
    public BookResponseDto getBook(Long id) {
        // 주어진 ID에 해당하는 도서를 찾아서 반환, 없으면 예외를 던짐
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("책을 찾지 못했습니다."));
        return new BookResponseDto(book);
    }
}


//위 코드는 BookService라는 서비스 클래스입니다. 주석을 통해 각 메서드가 수행하는 작업에 대한 설명이 포함되어 있습니다.
// 이 서비스 클래스는 도서 관련 비즈니스 로직을 처리하며, 도서 등록, 모든 도서 조회, 선택 도서 조회를 담당합니다.
// 주석을 통해 각 메서드가 수행하는 역할을 설명해 두었습니다.