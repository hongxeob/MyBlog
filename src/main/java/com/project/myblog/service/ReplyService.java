package com.project.myblog.service;

import com.project.myblog.dto.ReplyDto;
import com.project.myblog.model.Board;
import com.project.myblog.model.Reply;
import com.project.myblog.model.User;
import com.project.myblog.repository.BoardRepository;
import com.project.myblog.repository.ReplyRepository;
import com.project.myblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;

    @Transactional
    public Long writeReply(User user, Long boardId, ReplyDto replyDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException());
        replyDto.setBoard(board);
        replyDto.setUser(user);
        Reply reply = replyDto.toEntity();
        replyRepository.save(reply);
        return reply.getId();
    }

    @Transactional(readOnly = true)
    public List<ReplyDto> findAll(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id = " + id));
        List<Reply> replyList = board.getReplyList();
        return replyList.stream().map(new ReplyDto()::toDto).collect(Collectors.toList());
    }

    public void deleteReply(Long replyId) {
        Reply reply = replyRepository.findById(replyId).orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다. id = " + replyId));
        replyRepository.delete(reply);
    }
}
