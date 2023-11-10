package com.sparta.book.dto;

import com.sparta.book.entity.Book;
import com.sparta.book.entity.Loan;
import com.sparta.book.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
// LoanHistoryDto: 대출 이력 정보를 전달하는 데이터 객체
public class LoanHistoryDto {
    private String memberName; // 대출한 회원의 이름
    private String memberPhoneNumber; // 대출한 회원의 전화번호
    private String bookTitle; // 대출한 책의 제목
    private String bookAuthor; // 대출한 책의 작가
    private LocalDateTime loanDate; // 대출한 날짜

    // LoanHistoryDto의 생성자 - Book, Member, Loan 엔티티에서 데이터를 받아 초기화
    public LoanHistoryDto(Book book, Member member, Loan loan) {
        this.memberName = member.getUsername(); // 대출한 회원의 이름 할당
        this.memberPhoneNumber = member.getNumber(); // 대출한 회원의 전화번호 할당
        // 책 정보에서 제목과 작가를 가져오는 부분은 주석 처리되어 있어 사용되지 않음
        // this.bookTitle = book.setPage();
        // this.bookAuthor = book.getAuthor();
        this.loanDate = loan.getRegisteredDate(); // 대출 일자 할당
    }
}


//이 LoanHistoryDto 클래스는 대출 이력 정보를 전달하는 데이터 객체입니다.
// 대출한 회원의 이름, 전화번호, 대출한 책의 제목, 작가, 그리고 대출 날짜를 포함합니다.
// 주석을 통해 각 필드가 어떤 정보를 나타내는지 설명되어 있습니다.
// 생성자는 Book, Member, Loan 엔티티에서 데이터를 받아와서 해당 필드를 초기화합니다.
