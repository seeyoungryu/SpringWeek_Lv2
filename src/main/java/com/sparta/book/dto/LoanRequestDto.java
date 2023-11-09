package com.sparta.book.dto;

import lombok.Getter;

@Getter
public class LoanRequestDto {

    private Long bookId; // 대출 요청에서 책의 고유 식별자(ID)를 나타내는 필드
    private Long memberId; // 대출 요청을 한 회원의 고유 식별자(ID)를 나타내는 필드

}
