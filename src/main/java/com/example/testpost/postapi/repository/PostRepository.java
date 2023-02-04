package com.example.testpost.postapi.repository;

import com.example.testpost.postapi.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
