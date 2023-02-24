package com.project.myblog.service;

import com.project.myblog.dto.request.UserSaveRequestDto;
import com.project.myblog.model.Board;
import com.project.myblog.model.User;
import com.project.myblog.repository.BoardRepository;
import com.project.myblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    //모든 회원 리스트
    @Transactional(readOnly = true)
    public List<User> findAllUser() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC,"createdDate"));
    }

    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디를 찾을 수 없습니다"));
    }

    @Transactional(readOnly = true)
    public List<Board> findAllBoardByUser(User user) {
        return boardRepository.findAllByUserOrderByIdDesc(user);
    }

    @Transactional
    public void updateRole(Long id, UserSaveRequestDto userSaveRequestDto) {
        User findUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("회원 찾기 실패"));
        findUser.updateRole(userSaveRequestDto.getRole());
    }

    @Transactional
    public int getTotalViewCount() {
        int count = 0;
        List<Board> allBoard = boardRepository.findAll();
        for (Board board : allBoard) {
            count += board.getViews();
        }
        return count;
    }

    @Transactional
    public int getTotalUserCount() {
        int count = 0;
        List<User> allUser = userRepository.findAll();
        for (User user : allUser) {
            count += 1;
        }
        return count;
    }
}
