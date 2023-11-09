package com.sparta.book.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정


@Table(name = "loan")// 매핑할 테이블을 저장
@NoArgsConstructor
public class Loan extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "book_id", nullable = false) //도서id
    private Long bookId;
    @Column(name = "member_id", nullable = false)//멤버id
    private Long memberId;
    @Column(name = "loan_status", nullable = false)//대출상태
    private boolean loanStatus = true; // true: 대출 중, false: 반납
    @Column(name = "return_date", nullable = false)
    private LocalDateTime returnDate;

    public Long getId() {
        return id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public boolean getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(boolean loanStatus) {
        this.loanStatus = loanStatus;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }


}
