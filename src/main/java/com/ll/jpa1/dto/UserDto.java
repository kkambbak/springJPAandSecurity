package com.ll.jpa1.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
    private long member_id;

    private String userId;
    private String username;
    private String password;
    private String email;
    private String realname;
    private String roles;
}
