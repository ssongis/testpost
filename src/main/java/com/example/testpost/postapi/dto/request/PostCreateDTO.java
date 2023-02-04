package com.example.testpost.postapi.dto.request;

import com.example.testpost.postapi.entity.PostEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class PostCreateDTO {
    @NotBlank
    @Size(min = 2, max = 20)
    private String title;
    @NotBlank
    @Size(min = 1, max = 500)
    private String content;
    @NotBlank
    private String writer;

    // 이 dto를 엔터티로 변환
    public PostEntity toEntity() {
        return PostEntity.builder()
                .title(this.title)
                .content(this.content)
                .writer(this.writer)
                .build();
    }
}
