package com.ll.jpa1.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="TB_BOARD")
@SequenceGenerator(
        name="SEQ_BOARD_GENERATOR",
        sequenceName = "SEQ_TB_BOARD",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BoardDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BOARD_GENERATOR")
    private Long id;

    @Column(nullable=false, length=100)
    private String title;

    @Column(nullable=false, length=100)
    private String writer;

    @Column(nullable=false, length=100)
    private String contents;

    private LocalDateTime createdDate;
}
