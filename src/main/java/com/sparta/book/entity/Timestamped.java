package com.sparta.book.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter // Lombok을 통해 Getter 메서드를 자동으로 생성하는 어노테이션

@MappedSuperclass // 테이블로 매핑되지 않으며, 다른 엔티티 클래스들이 해당 클래스의 멤버를 상속할 수 있는 설정
@EntityListeners(AuditingEntityListener.class) // JPA Auditing을 통해 생성일, 수정일 관리를 위한 설정

public abstract class Timestamped {

    @CreatedDate // 생성일 관리를 위한 어노테이션
    @Column(updatable = false) // 데이터베이스의 열(column)을 나타내며, 수정 불가능한 설정
    @Temporal(TemporalType.TIMESTAMP) // 데이터베이스 저장을 위한 시간 정보 설정
    private LocalDateTime registeredDate; // 등록 날짜

    @LastModifiedDate // 수정일 관리를 위한 어노테이션
    @Column // 데이터베이스의 열(column)을 나타냄
    @Temporal(TemporalType.TIMESTAMP) // 데이터베이스 저장을 위한 시간 정보 설정
    private LocalDateTime returnDate; // 수정 날짜

}
