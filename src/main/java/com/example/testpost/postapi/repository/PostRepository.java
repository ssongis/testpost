package com.example.testpost.postapi.repository;

import com.example.testpost.postapi.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    // 게시물 목록 조회하기
    List<PostEntity> findAll();

    // 작성자로 조회하기
    List<PostEntity> findByWriter(String writer);

    // 제목으로 조회하기
    //@Query("select p from PostEntity p where p.title like ?1")
    //List<PostEntity> findAllByTitleLike(String title);
}
