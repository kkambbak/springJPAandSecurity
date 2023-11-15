package com.ll.jpa1.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="TB_USER")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserDto {

    @Id
    private long userId;

    private String username;
    private String password;
    private String email;
    private String realname;
    private String roles;

    public void encodePassword(String password) {
        this.password = password;
    }
}
