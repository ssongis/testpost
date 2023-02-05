package com.example.testpost.postapi.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "postdb")
public class PostEntity {

    public static long sequence = 1L; // 연속된 일련번호

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    @Column(nullable = false)
    @Size(min = 2, max = 20)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    @Size(min = 1, max = 500)
    private String content;
    @Column(nullable = false)
    private String writer;
    @CreationTimestamp
    private LocalDateTime regDate;

}
