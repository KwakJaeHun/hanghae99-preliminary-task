package com.jhkwak.task.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;
}