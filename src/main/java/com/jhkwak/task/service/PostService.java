package com.jhkwak.task.service;

import com.jhkwak.task.dto.PostRequestDto;
import com.jhkwak.task.dto.PostResponseDto;
import com.jhkwak.task.entity.Post;
import com.jhkwak.task.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    // 게시글 생성 Service
    public PostResponseDto createPost(PostRequestDto postRequestDto){

        System.out.println("Controlelr createPost 접근");

        // Post Entity에 전달받은 데이터 저장
        Post post = new Post(postRequestDto);
        
        // DB에 Post Entity 데이터 생성
        Post savePost = postRepository.save(post);

        // ResponseDto에 Enttiy 데이터 저장
        PostResponseDto postResponseDto = new PostResponseDto(savePost);

        return postResponseDto;
    }

    // 게시글 전체 조회
    public List<PostResponseDto> getAllPost(){
        // DB Post 전체 데이터 조회
        return postRepository.findAll().stream().map(PostResponseDto::new).toList();
    }

    // 게시글 상세 조회
    public List<PostResponseDto> getPostDetail(Long id){
        // id에 맞는 게시글 존재 확인
        Post post = findPost(id);

        // 존재시 DB Post 전체 데이터 중 id 조건에 맞는 데이터 검색
        return postRepository.findAllById(id).stream().map(PostResponseDto::new).toList();
    }

    // 게시글 업데이트
    @Transactional
    public Post updatePost(Long id, PostRequestDto postRequestDto){
        
        // id에 맞는 게시글 존재 확인
        Post post = findPost(id);
        
        // 존재시 Entity 업데이트
        post.update(postRequestDto);
        return post;
    }


    // 게시글 삭제
    public void deletePost(Long id){

        // id에 맞는 게시글 존재 확인
        Post post = findPost(id);

        postRepository.delete(post);
    }
    
    // 게시글 존재 여부 확인 , 없을시 오류 출력
    private Post findPost(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
    }
}
