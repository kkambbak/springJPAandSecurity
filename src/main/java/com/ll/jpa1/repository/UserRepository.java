package com.ll.jpa1.repository;

import com.ll.jpa1.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Long> {

    @Query("select u from UserDto u where u.username=:username")
    UserDto findByUsername(@Param("username") String username);
}
