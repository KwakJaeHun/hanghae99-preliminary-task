package com.jhkwak.task.controller;

import com.jhkwak.task.dto.PostRequestDto;
import com.jhkwak.task.dto.PostResponseDto;
import com.jhkwak.task.entity.Post;
import com.jhkwak.task.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시글 생성 Controller
    @PostMapping
    public PostResponseDto createPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.createPost(postRequestDto);

    }

    // 게시글 전체 조회 Controller
    @GetMapping
    public List<PostResponseDto> getAllPost() {

        return postService.getAllPost();

    }

    // 게시글 상세조회 Controller
    @GetMapping("/{id}")
    public List<PostResponseDto> getPostDetail(@PathVariable Long id) {

        return postService.getPostDetail(id);

    }

    // 게시글 업데이트 Controller
    @PutMapping("/{id}")
    public Post updateMemo(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {

        return postService.updatePost(id, postRequestDto);

    }

    // 게시글 삭제 Controller
    @DeleteMapping("/{id}")
    public Map deleteMemo(@PathVariable Long id) {

        postService.deletePost(id);

        HashMap<String,String> deleteComplete = new HashMap<String,String>();
        deleteComplete.put("msg", "삭제완료");

//        List<String> deleteComplete = new LinkedList<>();
//        deleteComplete.add("{\"msg\" : \"삭제완료\"}");

        return deleteComplete;

    }

}
