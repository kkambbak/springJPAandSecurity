package com.ll.jpa1.controller;

import com.ll.jpa1.dto.BoardDto;
import com.ll.jpa1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/list")
    public List<BoardDto> getAllList(BoardDto dto, Pageable pageable) {
        return service.getList(dto, pageable);
    }
}
