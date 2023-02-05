package com.example.testpost.postapi.dto.response;

import com.example.testpost.postapi.entity.PostEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Setter@Getter@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder

public class PostDetailResponseDTO {
    private String title;
    private String content;
    private String writer;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime regDate;


    // 엔터티를 dto로 변경하는 생성자
    public PostDetailResponseDTO(PostEntity entity){
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.regDate = entity.getRegDate();
    }
}
