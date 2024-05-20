package com.jhkwak.task.dto;

import com.jhkwak.task.entity.Post;
import lombok.Getter;

@Getter
public class PostAllResponseDto {
    private Long id;
    private String title;
    private int price;
    private String username;

    public PostAllResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.price = post.getPrice();
        this.username = post.getUsername();
    }
}
