package com.sparta.book.entity;

import com.sparta.book.dto.MemberRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // JPA에 의해 관리되는 엔티티 클래스임을 나타냄
//@Table(name = "member") // 데이터베이스에서 매핑할 테이블 이름 지정 (주석 처리하여 사용하지 않음)
@NoArgsConstructor // 인자 없는 기본 생성자 생성
@Getter // Getter 자동 생성
@Setter // Setter 자동 생성
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 멤버 ID

    @Column(name = "username", nullable = false)
    private String username; // 멤버명

    @Column(name = "gender", nullable = false)
    private String gender; // 성별

    @Column(name = "ssn", nullable = false, unique = true)
    private String ssn; // 주민등록번호 (고유한 값)

    @Column(name = "number", nullable = false, unique = true)
    private String number; // 회원 번호 (고유한 값)

    @Column(name = "address", nullable = false)
    private String address; // 주소

    // Getter 메서드: 멤버 ID 반환
    public Long getId(){
        return id;
    }

    // Getter 메서드: 멤버명 반환
    public String getUsername(){
        return username;
    }

    // Setter 메서드: 멤버명 설정
    public void setUsername(String username){
        this.username = username;
    }

    // Getter 메서드: 성별 반환
    public String getGender(){
        return gender;
    }

    // Setter 메서드: 성별 설정
    public void setGender(String gender){
        this.gender = gender;
    }

    // Getter 메서드: 주민등록번호 반환
    public String getSsn(){
        return ssn;
    }

    // Setter 메서드: 주민등록번호 설정
    public void setSsn(String ssn){
        this.ssn = ssn;
    }

    // Getter 메서드: 회원 번호 반환
    public String getNumber(){
        return number;
    }

    // Setter 메서드: 회원 번호 설정
    public void setNumber(String number){
        this.number = number;
    }

    // Getter 메서드: 주소 반환
    public String getAddress(){
        return address;
    }

    // Setter 메서드: 주소 설정
    public void setAddress(String address){
        this.address = address;
    }

    // MemberRequestDto로부터 멤버 엔티티를 초기화하는 생성자
    public Member(MemberRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.gender = requestDto.getGender();
        this.ssn = requestDto.getSsn();
        this.number = requestDto.getNumber();
        this.address = requestDto.getAddress();
    }
}
