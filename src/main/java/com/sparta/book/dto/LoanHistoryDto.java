package com.sparta.book.dto;

import com.sparta.book.entity.Loan;
import com.sparta.book.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.awt.print.Book;
import java.time.LocalDateTime;

@Getter
@Setter
public class LoanHistoryDto {
    private String memberName;
    private String memberPhoneNumber;
    private String bookTitle;
    private String bookAuthor;
    private LocalDateTime loanDate;

    public LoanHistoryDto(Book book, Member member, Loan loan){
        this.memberName = member.getUsername();
        this.memberPhoneNumber = member.getNumber();
//        this.bookTitle = book.setPage();
//        this.bookAuthor = book.getAuthor();
        this.loanDate = loan.getRegisteredDate();
    }

}
