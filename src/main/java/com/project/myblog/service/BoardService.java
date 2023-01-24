package com.project.myblog.service;

import com.project.myblog.model.Board;
import com.project.myblog.model.User;
import com.project.myblog.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public void write(Board board, User user) {
        board.setHits(0);
        board.setUser(user);
        boardRepository.save(board);
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
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
