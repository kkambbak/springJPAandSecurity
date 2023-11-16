package com.ll.jpa1.dto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="TB_USER")
@SequenceGenerator(
        name="SEQ_USER_GENERATOR",
        sequenceName = "SEQ_TB_USER",
        initialValue = 1,
        allocationSize = 1
)
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_GENERATOR")
    private Long userId;

    private String username;
    private String password;
    private String email;
    private String realname;
    private String roles;

    public void encodePassword(String password) {
        this.password = password;
    }
}
