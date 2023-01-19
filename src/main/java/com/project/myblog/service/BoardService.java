package com.project.myblog.service;

import com.project.myblog.model.Board;
import com.project.myblog.model.User;
import com.project.myblog.repository.BoardRepository;
import com.project.myblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public void write(Board board,User user) {
        board.setHits(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    public List<Board> list() {
        return boardRepository.findAll();
    }
}
