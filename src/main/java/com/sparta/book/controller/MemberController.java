package com.sparta.book.controller;

import com.sparta.book.dto.MemberRequestDto;
import com.sparta.book.dto.MemberResponseDto;
import com.sparta.book.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원 등록
    @PostMapping("/members")
    public MemberResponseDto createMember(@RequestBody MemberRequestDto requestDto) {
        // 회원 등록 서비스를 호출하여 새 회원을 등록합니다.
        return memberService.registerMember(requestDto);
    }

    // 선택 회원 조회
    @GetMapping("/members/{id}")
    public MemberResponseDto getMember(@PathVariable Long id) {
        // 특정 ID의 회원 정보를 가져옵니다.
        return memberService.getMember(id);
    }

    // 모든 회원 조회
    @GetMapping("/members")
    public List<MemberResponseDto> getAllMembers() {
        // 모든 회원의 정보를 가져옵니다.
        return memberService.getAllMembers();
    }
}
