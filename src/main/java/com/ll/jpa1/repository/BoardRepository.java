package com.ll.jpa1.repository;

import com.ll.jpa1.dto.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardDto, Long> {
    List<BoardDto> findByTitleOrderByIdDesc(String title);
}
