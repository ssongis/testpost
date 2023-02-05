package com.example.testpost.postapi.service;

import com.example.testpost.postapi.dto.request.PostCreateDTO;
import com.example.testpost.postapi.dto.request.PostModifyRequestDTO;
import com.example.testpost.postapi.dto.response.PostDetailResponseDTO;
import com.example.testpost.postapi.dto.response.PostListResponseDTO;
import com.example.testpost.postapi.entity.PostEntity;
import com.example.testpost.postapi.repository.PostRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    // 게시물 목록 조회
//    @Transactional
    public PostListResponseDTO retrieve(final Long bno){
        // 입력한 제목을 통해 목록 조회
        List<PostEntity> originalPost = postRepository.findAll();

        log.info("================= {}개의 게시물이 존재합니다. =================", originalPost.stream().count());

        // 엔티티 리스트를 dto리스트로 변환해서 클라이언트에 응답
        List<PostDetailResponseDTO> dtoList = originalPost.stream()
                .map(PostDetailResponseDTO::new)
                .collect(Collectors.toList());

        return PostListResponseDTO.builder()
                .posts(dtoList)
                .build();
    }

    // 게시물 개별 조회
    // 위의 값

    public PostListResponseDTO detail(final String writer){
        // Problem : writer로 쓰면 3개의 값이 전부 들어옴... 실제 값 비타오백 넣으면 해당 목록만 나옴...

        List<PostEntity> originalDetailPost = postRepository.findByWriter(writer);

        log.info("================= {}개의 게시물이 존재합니다. =================", originalDetailPost.stream().count());

        // 엔터티를 DTO로 변환
        List<PostDetailResponseDTO> dtoDetailList = originalDetailPost.stream()
                .map(PostDetailResponseDTO::new)
                .collect(Collectors.toList());

        return PostListResponseDTO.builder()
                .posts(dtoDetailList)
                .build();
    }


    // 게시물 삭제
//    public PostListResponseDTO delete(final Long bno) {
//        try {
//            postRepository.deleteById(bno);
//        } catch (Exception e) {
//            log.error("게시물 번호 존재하지 않아 삭제에 실패했습니다. - bno: {}, err: {}"
//                    , bno, e.getMessage());
//            throw new RuntimeException("게시물 번호가 존재하지 않아 삭제에 실패했습니다.");
//        }
//        return retrieve(bno);
//    }

}
