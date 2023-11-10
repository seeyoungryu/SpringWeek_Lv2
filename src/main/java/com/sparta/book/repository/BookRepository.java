package com.sparta.book.repository;

import com.sparta.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Book 엔티티를 다루는 JpaRepository
public interface BookRepository extends JpaRepository<Book, Long> {

    // 등록일을 기준으로 오름차순으로 모든 책을 가져오는 메서드
    List<Book> findAllByOrderByRegisteredDateAsc();
}


//위 코드는 Spring의 JpaRepository를 확장하여 Book 엔티티를 다루는 BookRepository를 정의하고 있습니다.
// findAllByOrderByRegisteredDateAsc 메서드는 등록일을 기준으로 오름차순으로 모든 책을 가져오는 메서드입니다.
// JpaRepository를 활용하면 데이터베이스와 상호작용하는데 필요한 여러 메서드를 간단하게 구현할 수 있습니다.
// 주석을 통해 해당 메서드가 무엇을 수행하는지 명확하게 설명하고 있습니다.