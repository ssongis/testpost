package com.example.testpost.postapi.controller;

import com.example.testpost.postapi.dto.request.PostCreateDTO;
import com.example.testpost.postapi.dto.response.PostDetailResponseDTO;
import com.example.testpost.postapi.dto.response.PostListResponseDTO;
import com.example.testpost.postapi.service.PostService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static java.util.stream.Collectors.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/posts")
@Builder

public class PostApiController {

    private final PostService postService;

    // 게시물 등록
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PostCreateDTO createDTO) {
        log.info("/api/posts POST! - {}", createDTO);
        PostDetailResponseDTO detailResponseDTO = postService.create(createDTO);
        return ResponseEntity
                .ok()
                .body(detailResponseDTO);
    }

    // 게시물 목록 조회
    @GetMapping
    public ResponseEntity<?> read(Long bno){

        PostListResponseDTO listResponseDTO = postService.retrieve(bno);
        log.info("/api/posts GET! - {}", listResponseDTO);

        return ResponseEntity
                .ok()
                .body(listResponseDTO);
    }

//    // 게시물 개별 조회
//    @GetMapping("/{writer}")
//    public ResponseEntity<?> detailRead(String writer){
//
//        PostListResponseDTO listDetailResponseDTO = postService.detail(writer);
//        log.info("/api/posts GET! - {}", listDetailResponseDTO);
//
//        return ResponseEntity
//                .ok()
//                .body(listDetailResponseDTO);
//    }


    // 게시물 삭제
//    @DeleteMapping("/{bno}")
//    public ResponseEntity<?> deleteTodo(Long bno) {
//        log.info("/api/todos/{} DELETE request!", bno);
//        PostListResponseDTO responseDTO = postService.delete(bno);
//        return ResponseEntity.ok().body(responseDTO);
//    }
}
