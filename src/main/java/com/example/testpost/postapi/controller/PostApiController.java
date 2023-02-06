package com.example.testpost.postapi.controller;

import com.example.testpost.postapi.dto.request.PostCreateDTO;
import com.example.testpost.postapi.dto.request.PostModifyRequestDTO;
import com.example.testpost.postapi.dto.response.PostDetailResponseDTO;
import com.example.testpost.postapi.dto.response.PostListResponseDTO;
import com.example.testpost.postapi.service.PostService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
        log.info("/api/posts POST request! - {}", createDTO);
        PostDetailResponseDTO detailResponseDTO = postService.create(createDTO);
        return ResponseEntity
                .ok()
                .body(detailResponseDTO);
    }

    // 게시물 목록 조회
    @GetMapping
    public ResponseEntity<?> read(Long bno){
        log.info("/posts GET request");
        PostListResponseDTO listResponseDTO = postService.retrieve(bno);
        log.info("/api/posts GET! - {}", listResponseDTO);

        return ResponseEntity
                .ok()
                .body(listResponseDTO);
    }

    // 게시물 개별 조회
    @GetMapping("/{writer}")
    public ResponseEntity<?> detailRead(String writer){
        try {
            PostListResponseDTO listDetailResponseDTO = postService.detail(writer);
            log.info("/api/posts/{} GET request!", writer); // null
            log.info("/api/posts GET! - {}", listDetailResponseDTO);

            return ResponseEntity
                    .ok()
                    .body(listDetailResponseDTO);

        } catch (Exception e) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    // 게시물 수정
    @PatchMapping("/{bno}")
    public ResponseEntity<?> modify(
            @PathVariable Long bno
            , @RequestBody PostModifyRequestDTO modifyDTO
    ) {
        log.info("/api/posts/{} PUT request!", bno);
        log.info("수정정보: {}", modifyDTO);

        try {
            PostDetailResponseDTO responseDTO = postService.update(bno, modifyDTO);
            return ResponseEntity
                    .ok()
                    .body(responseDTO);
        } catch (RuntimeException e) {
            log.error("수정 실패: caused by - {}", e.getMessage());
            return ResponseEntity
                    .internalServerError()
                    .body(e.getMessage());
        }
    }

    // 게시물 삭제
    @DeleteMapping("/{bno}")
    public ResponseEntity<?> remove(@PathVariable Long bno) {
        log.info("/posts/{} DELETE request", bno);
        try {
            postService.delete(bno);
            return ResponseEntity.ok().body("삭제 성공!");
        } catch (RuntimeException e) {
            return ResponseEntity
                    .internalServerError()
                    .body(e.getMessage());
        }
    }
}
