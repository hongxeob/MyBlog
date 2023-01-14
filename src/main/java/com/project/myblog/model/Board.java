package com.project.myblog.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 MySQL에 자동으로 테이블 생성
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false,length = 100)
    private String title;


    @Lob //대용량 데이터
    private String content; //섬머노트 라이브러리 사용 -<html> 태크 섞여 디자인

    //조회수
    //    @ColumnDefault("0")
    private int hits;

    @DateTimeFormat(pattern = "yyyy-mm-dd HH:mm")
    private LocalDateTime createDate;

    //글쓴이
    //DB는 오브젝트 저장X-> FK사용, 자바는 오브젝트 저장 가능
    @ManyToOne(fetch = FetchType.EAGER) //EAGER=호출시 바로 로드
    @JoinColumn(name = "userId") //DB상 필드값은 userId로 설정
    private User user;

}
