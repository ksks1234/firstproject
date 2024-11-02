package com.example.firstproject.enetity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor // 기본 생성자 추가 어노테이션
@ToString
@Getter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id 자동 생성
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

}
