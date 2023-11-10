package com.sparta.book.dto;

import lombok.Getter;

@Getter // Lombok을 통해 Getter 메서드를 자동으로 생성합니다.

// BookRequestDto: 책 정보를 나타내는 데이터 전송 객체
public class BookRequestDto {

    // 책의 제목을 나타내는 문자열
    private String title;

    // 책의 작가를 나타내는 문자열
    private String author;

    // 책의 언어를 나타내는 문자열
    private String language;

    // 책의 출판사를 나타내는 문자열
    private String publisher;
}



//이 데이터 전송 객체는 책의 정보를 나타내며, 제목, 작가, 언어, 출판사와 같은 속성들을 포함합니다.
// Lombok의 @Getter 어노테이션을 사용하여 Getter 메서드를 자동으로 생성하고, 데이터를 안전하게 읽을 수 있도록 해줍니다.