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

    // 게시물 수정
}
