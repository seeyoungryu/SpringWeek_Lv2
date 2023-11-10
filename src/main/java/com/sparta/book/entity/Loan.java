package com.sparta.book.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity // JPA에 의해 관리되는 엔티티 클래스임을 나타냄
@Table(name = "loan") // 데이터베이스에서 매핑할 테이블을 지정
@NoArgsConstructor
public class Loan extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id", nullable = false)
    private Long bookId; // 도서 ID

    @Column(name = "member_id", nullable = false)
    private Long memberId; // 멤버 ID

    @Column(name = "loan_status", nullable = false)
    private boolean loanStatus = true; // 대출 상태: true는 대출 중, false는 반납

    @Column(name = "return_date", nullable = false)
    private LocalDateTime returnDate; // 반납 날짜

    // Getter 메서드: 대출 ID 반환
    public Long getId() {
        return id;
    }

    // Getter 메서드: 도서 ID 반환
    public Long getBookId() {
        return bookId;
    }

    // Setter 메서드: 도서 ID 설정
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    // Getter 메서드: 멤버 ID 반환
    public Long getMemberId() {
        return memberId;
    }

    // Setter 메서드: 멤버 ID 설정
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    // Getter 메서드: 대출 상태 반환
    public boolean getLoanStatus() {
        return loanStatus;
    }

    // Setter 메서드: 대출 상태 설정
    public void setLoanStatus(boolean loanStatus) {
        this.loanStatus = loanStatus;
    }

    // Getter 메서드: 반납 날짜 반환
    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    // Setter 메서드: 반납 날짜 설정
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
