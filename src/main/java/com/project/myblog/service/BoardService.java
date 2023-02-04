package com.project.myblog.service;

import com.project.myblog.dto.BoardDto;
import com.project.myblog.model.Board;
import com.project.myblog.model.User;
import com.project.myblog.repository.BoardRepository;
import com.project.myblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public void write(BoardDto boardDto, User user) {
        boardDto.setUser(user);
        Board saveBoard = boardDto.toEntity();
        boardRepository.save(saveBoard);
    }

    @Transactional(readOnly = true) // 읽기 전용 -> 상태변화X->영속성 컨텍스트 관리X
    public Page<Board> list(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true) // 읽기 전용 -> 상태변화X->영속성 컨텍스트 관리X
    public Board details(Long id) {
        return boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("아이디를 찾을 수 없습니다");
        });
    }

    @Transactional
    public int updateViews(Long id) {
        return boardRepository.updateViews(id);
    }

    @Transactional
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, BoardDto requestBoard) {
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("글을 찾을 수 없습니다");
        }); // -> 영속화 완료
        board.updateBoard(requestBoard.getTitle(), requestBoard.getContent());
        // 바로 값만 새로 세팅해주면 된다
        // 해당 함수 종료시 트랜잭션 종료되고 더티체킹 후 플러시(자동 업데이트)
    }
}
