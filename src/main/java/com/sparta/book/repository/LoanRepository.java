package com.sparta.book.repository;

import com.sparta.book.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Loan 엔티티를 다루는 JpaRepository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    // bookId와 대출 상태(대출 중인지)를 확인하는 메서드
    boolean existsByBookIdAndLoanStatus(Long bookId, boolean loanStatus);

    // 특정 회원의 대출 상태(대출 중인지)를 확인하는 메서드
    Long countByMemberIdAndLoanStatus(Long memberId, boolean loanStatus);

    // 특정 회원의 모든 대출을 등록 날짜를 기준으로 오름차순으로 가져오는 메서드
    List<Loan> findAllByMemberIdOrderByRegisteredDateAsc(Long memberId);

    // 특정 회원의 모든 대출을 가져오는 메서드
    List<Loan> findAllByMemberId(Long memberId);
}

//해당 코드는 Spring의 JpaRepository를 확장하여 Loan 엔티티를 다루는 LoanRepository를 정의하고 있습니다.
// 여러 메서드를 통해 특정 조건에 따라 대출 정보를 가져오거나 존재 여부를 확인할 수 있습니다.
// 주석을 통해 각 메서드가 수행하는 작업에 대한 설명이 포함되어 있습니다.
