package com.sparta.book.entity;


import com.sparta.book.dto.MemberRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정

//@Table(name = "member")// 매핑할 테이블을 저장
@NoArgsConstructor
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "ssn", nullable = false, unique = true)
    private String ssn;
    @Column(name = "number", nullable = false, unique = true)
    private String number;
    @Column(name = "address", nullable = false)
    private String address;

    public Long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender =gender;
    }

    public String getSsn(){
        return ssn;
    }
    public void setSsn(String ssn){
        this.ssn = ssn;
    }

    public String getNumber(){
        return number;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public Member(MemberRequestDto requestDto) {

        this.username = requestDto.getUsername();
        this.gender = requestDto.getGender();
        this.ssn = requestDto.getSsn();
        this.number = requestDto.getNumber();
        this.address = requestDto.getAddress();

    }




}
