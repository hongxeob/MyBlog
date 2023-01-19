package com.project.myblog.repository;

import com.project.myblog.model.Board;
import com.project.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
