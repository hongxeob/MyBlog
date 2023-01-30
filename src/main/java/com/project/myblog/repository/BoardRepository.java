package com.project.myblog.repository;

import com.project.myblog.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Modifying
    @Query("update Board p set p.views = p.views + 1 where p.id = :id")
    int updateViews(@Param("id") Long id);
}
