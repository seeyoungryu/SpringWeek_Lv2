package com.sparta.book.dto;

import com.sparta.book.entity.Loan;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter // Lombok을 통해 Getter 메서드를 자동으로 생성합니다.

// LoanResponseDto: 대출 정보에 대한 응답 데이터 객체
public class LoanResponseDto {
    private Long id; // 대출의 고유 식별자(ID)
    private Long bookId; // 대출된 책의 ID
    private Long memberId; // 대출한 회원의 ID
    private boolean loanStatus; // 대출 상태 (대출 중/반납 완료)
    private LocalDateTime registeredDate; // 대출 등록 일자
    private LocalDateTime returnDate; // 반납 일자

    // LoanResponseDto의 생성자 - Loan 엔티티로부터 데이터를 받아 초기화
    public LoanResponseDto(Loan loan) {
        this.id = loan.getId(); // 대출의 ID 할당
        this.bookId = loan.getBookId(); // 대출된 책의 ID 할당
        this.memberId = loan.getMemberId(); // 대출한 회원의 ID 할당
        this.loanStatus = loan.getLoanStatus(); // 대출 상태 할당
        this.registeredDate = loan.getRegisteredDate(); // 대출 등록 일자 할당
        this.returnDate = loan.getReturnDate(); // 반납 일자 할당
    }
}

//이 LoanResponseDto 클래스는 대출 정보에 대한 응답용 데이터 객체입니다.
// 대출의 고유 식별자, 대출된 책과 회원의 ID, 대출 상태, 등록 및 반납 일자를 나타내는 여러 필드를 가지고 있습니다.
// 주석을 통해 각 필드가 어떤 정보를 나타내는지 설명되어 있습니다.
// 생성자는 Loan 엔티티로부터 데이터를 받아와서 해당 필드를 초기화합니다.
