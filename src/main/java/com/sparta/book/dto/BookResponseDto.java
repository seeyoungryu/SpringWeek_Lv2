package com.sparta.book.dto;

import com.sparta.book.entity.Book;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter // Lombok을 통해 Getter 메서드를 자동으로 생성합니다.

// BookResponseDto: 책 정보를 전달하는 응답용 데이터 객체
public class BookResponseDto {
    private Long id; // 책의 고유 식별자(ID)
    private String title; // 책의 제목
    private String author; // 책의 작가
    private String language; // 책의 언어
    private String publisher; // 책의 출판사
    private LocalDateTime registeredDate; // 책이 등록된 일시

    // BookResponseDto의 생성자 - Book 엔티티로부터 데이터를 전달받아 초기화
    public BookResponseDto(Book book) {
        this.id = book.getId(); // 책의 ID 할당
        this.title = book.getTitle(); // 책의 제목 할당
        this.author = book.getAuthor(); // 책의 작가 할당
        this.language = book.getLanguage(); // 책의 언어 할당
        this.publisher = book.getPublisher(); // 책의 출판사 할당
        this.registeredDate = book.getRegisteredDate(); // 책의 등록일 할당
    }

    // 빈 생성자 혹은 다른 Book 타입의 객체를 위한 생성자
    public BookResponseDto(java.awt.print.Book book) {
        // 이 생성자는 다른 Book 타입을 사용하지만, 현재 코드에는 사용되지 않음
    }
}
