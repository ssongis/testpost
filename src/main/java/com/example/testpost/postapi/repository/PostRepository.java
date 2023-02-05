package com.example.testpost.postapi.repository;

import com.example.testpost.postapi.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    // 게시물 목록 조회하기
    List<PostEntity> findAll();

    // 작성자로 조회하기
//    List<PostEntity> findAllByWriter(String writer);



}
