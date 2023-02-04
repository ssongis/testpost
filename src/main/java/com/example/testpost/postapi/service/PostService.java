package com.example.testpost.postapi.service;

import com.example.testpost.postapi.dto.request.PostCreateDTO;
import com.example.testpost.postapi.dto.response.PostDetailResponseDTO;
import com.example.testpost.postapi.dto.response.PostListResponseDTO;
import com.example.testpost.postapi.entity.PostEntity;
import com.example.testpost.postapi.repository.PostRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
@Builder
public class PostService {
    private final PostRepository postRepository;

    // 게시물 등록
    public PostDetailResponseDTO create(PostCreateDTO createDTO) {
        PostEntity savedPost = postRepository.save(createDTO.toEntity());
        log.info("게시물 등록 성공!! - POST_NO: {}",savedPost.getBno());

        // save의 리턴 결과 저장
        return new PostDetailResponseDTO(savedPost);
    }

}
