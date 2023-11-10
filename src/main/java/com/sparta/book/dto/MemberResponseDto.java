package com.sparta.book.dto;

import com.sparta.book.entity.Member;
import lombok.Getter;

@Getter // Lombok을 통해 Getter 메서드를 자동으로 생성합니다.

// MemberResponseDto: 회원 정보에 대한 응답 데이터 객체
public class MemberResponseDto {

    private Long id; // 회원의 고유 식별자(ID)
    private String username; // 회원의 이름
    private String gender; // 회원의 성별
    private String number; // 회원의 전화번호
    private String address; // 회원의 주소

    // MemberResponseDto의 생성자 - Member 엔티티로부터 데이터를 받아 초기화
    public MemberResponseDto(Member member) {
        this.id = member.getId(); // 회원의 ID 할당
        this.username = member.getUsername(); // 회원의 이름 할당
        this.gender = member.getGender(); // 회원의 성별 할당
        this.number = member.getNumber(); // 회원의 전화번호 할당
        this.address = member.getAddress(); // 회원의 주소 할당
    }
}

//    위 코드는 MemberResponseDto 클래스로, 회원 정보에 대한 응답용 데이터 객체를 정의하고 있습니다.
//    이 객체는 회원의 ID, 이름, 성별, 전화번호, 주소와 같은 정보를 담고 있습니다.
//    생성자는 Member 엔티티로부터 데이터를 받아 해당 필드를 초기화합니다.
//    주석을 통해 각 필드가 어떤 정보를 나타내는지 설명되어 있습니다.
