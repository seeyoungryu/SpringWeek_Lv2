package com.sparta.book.repository;

import com.sparta.book.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {




    boolean existsByBookIdAndLoanStatus(Long bookId, boolean loanStatus);

    Long countByMemberIdAndLoanStatus(Long memberId, boolean loanStatus);

    List<Loan> findAllByMemberIdOrderByRegisteredDateAsc(Long memberId);
    List<Loan> findAllByMemberId(Long memberId);
}
