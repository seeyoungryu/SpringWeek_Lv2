package com.sparta.book.dto;

import com.sparta.book.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    private Long id;
    private String username;
    private String gender;
    private String number;
    private String address;


    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.username = member.getUsername();
        this.gender = member.getGender();
        this.number = member.getNumber();
        this.address = member.getAddress();


    }


}