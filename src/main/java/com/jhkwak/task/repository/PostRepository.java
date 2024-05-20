package com.jhkwak.task.repository;

import com.jhkwak.task.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
    // 게시물 고유 아이디로 조회
    List<Post> findAllById(Long id);
    
}

