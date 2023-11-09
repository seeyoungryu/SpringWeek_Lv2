package com.sparta.book.dto;

import com.sparta.book.entity.Loan;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LoanResponseDto {

    private Long id;
    private Long bookId;
    private Long memberId;
    private boolean loanStatus;
    private LocalDateTime registeredDate;
    private LocalDateTime returnDate;


    public LoanResponseDto(Loan loan) {
        this.id = loan.getId();
        this.bookId = loan.getBookId();
        this.memberId = loan.getMemberId();
        this.loanStatus = loan.getLoanStatus();
        this.registeredDate = loan.getRegisteredDate();
        this.returnDate = loan.getReturnDate();


    }
}