package com.example.testpost.postapi.dto.response;

import com.example.testpost.postapi.entity.PostEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PostListResponseDTO {
    private String error; // 에러발생시 클라이언트에게 전달할 메시지
    private List<PostDetailResponseDTO> posts;
    private int count;
}
