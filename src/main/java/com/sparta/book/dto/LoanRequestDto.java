package com.sparta.book.dto;

import lombok.Getter;

@Getter // Lombok을 통해 Getter 메서드를 자동으로 생성합니다.

// LoanRequestDto: 대출 요청 정보를 담는 데이터 전송 객체
public class LoanRequestDto {

    private Long bookId; // 대출하려는 책의 고유 식별자(ID)를 나타내는 필드
    private Long memberId; // 대출을 요청하는 회원의 고유 식별자(ID)를 나타내는 필드

    // bookId와 memberId 필드를 가지고 있는 대출 요청 데이터를 표현합니다.
}

//이 데이터 전송 객체는 대출 요청에 필요한 정보를 담고 있습니다. 주석을 통해 각 필드가 어떤 정보를 나타내는지 설명되어 있습니다.
// 또한, Lombok의 @Getter를 사용하여 Getter 메서드를 자동으로 생성하여, 이 객체의 속성에 접근할 때 사용할 수 있도록 합니다.
