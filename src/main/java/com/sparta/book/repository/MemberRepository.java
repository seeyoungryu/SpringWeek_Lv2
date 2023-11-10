package com.sparta.book.repository;

import com.sparta.book.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// Member 엔티티를 다루는 JpaRepository
public interface MemberRepository extends JpaRepository<Member, Long> {
}


//위의 코드는 Spring의 JpaRepository를 확장하여 Member 엔티티를 다루는 MemberRepository를 정의합니다.
// JpaRepository를 사용하면 데이터베이스와 상호작용하는데 필요한 기본적인 메서드들을 자동으로 제공받을 수 있습니다.
// 주석을 통해 해당 인터페이스가 Member 엔티티를 다룬다는 것을 명시하고 있습니다.