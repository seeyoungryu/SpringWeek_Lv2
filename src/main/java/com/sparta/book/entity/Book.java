package com.sparta.book.entity;


import jakarta.persistence.*;
import jdk.jfr.Relational;
import lombok.NoArgsConstructor;

@Entity //JPA 가 관리 할 수 있는 엔티티 클래스 지정
//@Table(name="book")
@NoArgsConstructor
//이 어노테이션은 JPA에서 엔티티 클래스를 데이터베이스 테이블과 매핑할 때 사용됩니다.
// 이를 통해 엔티티 클래스와 데이터베이스 스키마 간의 관계를 설정하고 데이터를 가져오고 저장할 수 있습니다.

public class Book extends Timestamped {
    @Id // 이 필드는 식별자(primary key) 역할을 한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성되는 식별자(strategy = GenerationType.IDENTITY)
    private Long id; // 게시물의 고유 식별자
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "language", nullable = false)
    private String language;
    @Column(name = "publisher", nullable = false)
    private String publisher;

//    주어진 코드 `@Column(name = "title", nullable = false)`은
//    스프링 프레임워크의 JPA(Java Persistence API)를 사용하여 데이터베이스와 자바 객체를 매핑하기 위한 부분입니다.
//
//            1. `@Column` : 이 어노테이션은 데이터베이스 테이블의 열(Column)에 대한 설정을 정의합니다.
//
//            2. `name = "title"`: 이 부분은 열의 이름을 "title"로 지정합니다.
//            데이터베이스 테이블에서 이 열은 "title"이라는 이름을 가지게 됩니다.
//
//            3. `nullable = false`: 이 부분은 해당 열이 null 값을 허용하지 않도록 설정합니다.
//            즉, 데이터베이스에 저장될 때 "title" 값은 반드시 비어있지 않아야 합니다.
//
//    이 코드는 자바 클래스 내에서 데이터베이스 열과 자바 객체의 필드를 매핑하는 데 사용됩니다.
//    이것은 주로 JPA와 관계형 데이터베이스를 사용하는 스프링 부트 애플리케이션에서 데이터 모델을 정의할 때 유용합니다.
//    이제 "title"이라는 열은 데이터베이스 테이블에 있고,
//    Java 클래스 내에서 `private String title` 필드로 데이터를 표현하는 데 사용됩니다.





}
