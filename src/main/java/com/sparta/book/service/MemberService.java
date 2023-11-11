package com.sparta.book.service;

import com.sparta.book.dto.MemberRequestDto;
import com.sparta.book.dto.MemberResponseDto;
import com.sparta.book.entity.Member;
import com.sparta.book.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

// MemberService: 회원과 관련된 비즈니스 로직을 처리하는 서비스 클래스
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 등록 메서드
    public MemberResponseDto registerMember(MemberRequestDto requestDto) {
        // MemberRequestDto를 이용해 Member 객체 생성 후 저장
        Member member = new Member(requestDto);
        memberRepository.save(member);
        // 등록된 Member 정보를 MemberResponseDto로 반환
        return new MemberResponseDto(member);
    }

    // 선택 회원 조회 메서드
    public MemberResponseDto getMember(Long id) {
        // 주어진 ID에 해당하는 회원 조회
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("회원을 찾지 못했습니다."));
        // 조회된 Member 정보를 MemberResponseDto로 반환
        return new MemberResponseDto(member);
    }

    // 모든 회원 조회 메서드
    public List<MemberResponseDto> getAllMembers() {
        // 모든 회원 정보 조회
        List<Member> members = memberRepository.findAll();
        // 모든 Member 정보를 MemberResponseDto 리스트로 변환하여 반환
        return members.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }
}

//해당 서비스 클래스는 회원과 관련된 작업을 처리합니다.
// 회원 등록, 회원 조회(특정 회원 및 모든 회원 조회)와 같은 기능을 제공합니다.
// 주석을 통해 각 메서드가 수행하는 역할에 대한 설명이 포함되어 있습니다.
//