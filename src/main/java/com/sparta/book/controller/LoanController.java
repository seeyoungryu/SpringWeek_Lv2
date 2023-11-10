package com.sparta.book.controller;

import com.sparta.book.dto.LoanHistoryDto;
import com.sparta.book.dto.LoanRequestDto;
import com.sparta.book.dto.LoanResponseDto;
import com.sparta.book.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    // 대출하기
    @PostMapping("/loan")
    public String loanBook(@RequestBody LoanRequestDto loanRequestDto) {
        try {
            // 대출 서비스를 호출하여 책을 대출합니다.
            loanService.loanBook(loanRequestDto);
            return "대출에 성공하였습니다."; // 대출 성공 시 메시지 반환

        } catch (IllegalArgumentException e) {
            // IllegalArgumentException 발생 시, 대출 실패 메시지와 예외 메시지 반환
            return "도서 대출에 실패했습니다: " + e.getMessage();
        }
    }

    // 선택 대출 목록 조회
    @GetMapping("/loan/{id}")
    public LoanResponseDto getLoan(@PathVariable Long id) {
        // 특정 ID에 해당하는 대출 정보를 요청합니다.
        return loanService.getLoan(id);
    }

    // 선택한 도서 반납 기능
    @PutMapping("/loan/return/{id}")
    public String returnBook(@PathVariable Long id) {
        try {
            // 책을 반납하는 서비스를 호출합니다.
            loanService.returnBook(id);
            return "도서 반납에 성공하였습니다"; // 반납 성공 시 메시지 반환
        } catch (IllegalArgumentException e) {
            // IllegalArgumentException 발생 시, 반납 실패 메시지와 예외 메시지 반환
            return "도서 반납에 실패하였습니다: " + e.getMessage();
        }
    }

    // 대출 내역 조회
    @GetMapping("/loan/history/{memberId}")
    public List<LoanHistoryDto> getLoanHistory(@PathVariable Long memberId) {
        // 특정 회원의 대출 내역을 조회합니다.
        return loanService.getMemberLoanHistory(memberId);
    }
}
