package com.ll.jpa1.service;


import com.ll.jpa1.dto.BoardDto;
import com.ll.jpa1.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardDto> getList(BoardDto dto, Pageable pageable) {
        return boardRepository.findAll(pageable).getContent();
    }

    public int getTotalCount(){
        return (int)boardRepository.count();
    }

    @Transactional
    public void insert(BoardDto dto)
    {
        //dto객체에 id 필드에 값이 없으면 insert가 직동.
        boardRepository.save(dto);
    }

    @Transactional
    public void update(BoardDto dto){
        //처리
        boardRepository.save(dto);
    }

    @Transactional
    public void delete(BoardDto dto){
        boardRepository.delete(dto);
    }

    public BoardDto findById(BoardDto dto){
        return boardRepository.findById(dto.getId()).orElseThrow(IllegalArgumentException::new);
    }
}
