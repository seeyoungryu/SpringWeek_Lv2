package com.sparta.book.entity;

import com.sparta.book.dto.BookRequestDto;
import com.sparta.book.entity.Timestamped;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Table(name = "book") // 매핑할 테이블을 지정
@NoArgsConstructor
public class Book extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "publisher", nullable = false)
    private String publisher;

    // 기본 생성자
    public Book() {}

    // BookRequestDto에서 받아온 정보를 사용하여 Book 객체를 생성하는 생성자
    public Book(BookRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.language = requestDto.getLanguage();
        this.publisher = requestDto.getPublisher();
    }

    // id 필드의 Getter
    public Long getId() {
        return id;
    }

    // title 필드의 Getter
    public String getTitle() {
        return title;
    }

    // title 필드의 Setter
    public void setTitle(String title) {
        this.title = title;
    }

    // author 필드의 Getter
    public String getAuthor() {
        return author;
    }

    // author 필드의 Setter
    public void setAuthor(String author) {
        this.author = author;
    }

    // language 필드의 Getter
    public String getLanguage() {
        return language;
    }

    // language 필드의 Setter
    public void setLanguage(String language) {
        this.language = language;
    }

    // publisher 필드의 Getter
    public String getPublisher() {
        return publisher;
    }

    // publisher 필드의 Setter
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
