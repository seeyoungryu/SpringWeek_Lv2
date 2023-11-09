package com.sparta.book.entity;

import com.sparta.book.dto.BookRequestDto;
import com.sparta.book.entity.Timestamped;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Table(name = "book")// 매핑할 테이블을 저장
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

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }
    public String getLanguage(){
        return language;
    }

    public void setLanguage(String language){
        this.language = language;
    }
    public String getPublisher(){
        return publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }


    public Book(BookRequestDto requestDto) {

        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.language = requestDto.getLanguage();
        this.publisher = requestDto.getPublisher();


    }

}