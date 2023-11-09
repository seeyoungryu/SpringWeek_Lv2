package com.sparta.book.service;

import com.sparta.book.dto.MemberRequestDto;
import com.sparta.book.dto.MemberResponseDto;
import com.sparta.book.entity.Member;
import com.sparta.book.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberResponseDto registerMember(MemberRequestDto requestDto) {
        Member member = new Member(requestDto);
        memberRepository.save(member);
        return new MemberResponseDto(member);
    }

    public MemberResponseDto getMember(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("회원을 찾지 못했습니다."));
        return new MemberResponseDto(member);
    }

    public List<MemberResponseDto> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map(MemberResponseDto::new).collect(Collectors.toList());
    }
}
