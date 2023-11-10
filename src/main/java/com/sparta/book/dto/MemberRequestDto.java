package com.sparta.book.dto;

import lombok.Getter;

@Getter // Lombok을 통해 Getter 메서드를 자동으로 생성합니다.

// MemberRequestDto: 회원 등록 요청 정보를 담는 데이터 전송 객체
public class MemberRequestDto {

    private String username; // 회원 이름을 나타내는 필드
    private String gender; // 회원 성별을 나타내는 필드
    private String ssn; // 회원 주민등록번호(SSN)를 나타내는 필드
    private String number; // 회원 전화번호를 나타내는 필드
    private String address; // 회원 주소를 나타내는 필드

    // username, gender, ssn, number, address 필드를 가지고 있는 회원 등록 요청 데이터를 표현합니다.
}


//이 데이터 전송 객체는 회원 등록을 위한 정보를 담고 있습니다.
// 각 필드는 회원의 이름, 성별, 주민등록번호, 전화번호, 주소와 같은 정보를 담고 있습니다.
// Lombok의 @Getter 어노테이션을 사용하여 Getter 메서드를 자동으로 생성하여,
// 이 객체의 속성에 접근할 수 있도록 합니다. 주석을 통해 각 필드가 어떤 정보를 나타내는지 설명되어 있습니다.