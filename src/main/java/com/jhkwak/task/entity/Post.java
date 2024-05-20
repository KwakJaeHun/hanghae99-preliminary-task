package com.jhkwak.task.entity;

import com.jhkwak.task.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "post")
@NoArgsConstructor
public class Post { // extends TimeStamped

    // 게시글 고유 Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 게시글 제목
    @Column(name = "title", nullable = false)
    private String title;

    // 게시글 내용
    @Column(name = "content", nullable = false)
    private String content;

    // 가격
    @Column(name = "price", nullable = false)
    private int price;

    // 작성자
    @Column(name = "username", nullable = false)
    private String username;


    public Post(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.price = postRequestDto.getPrice();
        this.username = postRequestDto.getUsername();
    }

    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.price = postRequestDto.getPrice();
        this.username = postRequestDto.getUsername();
    }
}