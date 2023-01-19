package com.project.myblog.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity // User 클래스가 MySQL에 자동으로 테이블 생성
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false, length = 100)
    private String title;


    @Lob //대용량 데이터
    private String content; //섬머노트 라이브러리 사용 -<html> 태크 섞여 디자인

    //조회수
    private int hits;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime localDateTime;

    @PrePersist
    public void createdAt() {
        this.localDateTime = LocalDateTime.now();
    }

    //글쓴이
    //DB는 오브젝트 저장X-> FK사용, 자바는 오브젝트 저장 가능
    @ManyToOne(fetch = FetchType.EAGER) //EAGER=호출시 바로 로드
    @JoinColumn(name = "userId") //DB상 필드값은 userId로 설정
    private User user;

    @OneToMany(mappedBy = "board",
            fetch = FetchType.EAGER, //설계한 프로젝트 UI 구조상 '댓글 펼치기' 같은 지연 로딩이 아닌, 게시판에 바로 댓글이 보이는 것이기에 EAGER 전략
            cascade = CascadeType.REMOVE) //Board(게시판)삭제시 댓글도 함께 삭제
    private List<Reply> replyList;
}
