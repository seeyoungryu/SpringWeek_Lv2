package com.sparta.book.service;

import com.sparta.book.entity.Book;
import com.sparta.book.dto.LoanHistoryDto;
import com.sparta.book.dto.LoanRequestDto;
import com.sparta.book.dto.LoanResponseDto;
import com.sparta.book.entity.Loan;
import com.sparta.book.entity.Member;
import com.sparta.book.repository.BookRepository;
import com.sparta.book.repository.LoanRepository;
import com.sparta.book.repository.MemberRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter

// LoanService: 대출 관련 비즈니스 로직을 처리하는 서비스 클래스
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    // 서비스 클래스의 생성자
    public LoanService(LoanRepository loanRepository, BookRepository bookRepository, MemberRepository memberRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    // 도서 대출 메서드
    public void loanBook(LoanRequestDto loanRequestDto) {
        // 선택한 도서와 회원의 존재 확인
        Book book = bookRepository.findById(loanRequestDto.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("책 정보가 없습니다"));
        Member member = memberRepository.findById(loanRequestDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("회원 정보가 없습니다"));

        // 반납하지 않은 책이 있는지 확인
        if (loanRepository.countByMemberIdAndLoanStatus(member.getId(), true) > 0) {
            throw new IllegalArgumentException("아직 반납되지 않은 도서가 있습니다.");
        }

        // 선택한 도서의 현재 대출 상태 확인
        if (loanRepository.existsByBookIdAndLoanStatus(book.getId(), true)) {
            throw new IllegalArgumentException("선택한 도서는 이미 대출 중입니다.");
        }

        // 대출 내역 저장
        Loan loan = new Loan();
        loan.setBookId(book.getId());
        loan.setMemberId(member.getId());
        loan.setLoanStatus(true);
        loan.setReturnDate(LocalDateTime.now().plusDays(7)); // 7일 후 반납 예정

        loanRepository.save(loan);
    }

    // 선택 도서 조회 메서드
    public LoanResponseDto getLoan(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("정보를 찾지 못했습니다."));
        return new LoanResponseDto(loan);
    }

    // 대출 내역의 반납 상태와 반납일 변경 메서드
    public void returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new IllegalArgumentException("해당 도서의 대출 내역이 없습니다."));
        loan.setLoanStatus(false); // 대출 상태를 반납으로 변경
        loan.setReturnDate(LocalDateTime.now()); // 반납일 설정
        loanRepository.save(loan);
    }

    // 대출 내역 조회 메서드
    public List<LoanHistoryDto> getMemberLoanHistory(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원 정보가 없습니다."));
        List<Loan> loans = loanRepository.findAllByMemberIdOrderByRegisteredDateAsc(memberId);

        // 대출 내역을 LoanHistoryDto로 변환하여 리스트로 반환
        return loans.stream().map(loan -> {
            Book book = bookRepository.findById(loan.getBookId())
                    .orElseThrow(() -> new IllegalArgumentException("책 정보가 없습니다."));
            return new LoanHistoryDto(book, member, loan);
        }).collect(Collectors.toList());
    }
}


