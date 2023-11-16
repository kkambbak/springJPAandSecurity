package com.ll.jpa1.service;

import com.ll.jpa1.dto.UserDto;
import com.ll.jpa1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //아이디 중복체크 생략
    @Transactional
    public void userRegister(UserDto userDto){
        UserDto save = userRepository.save(userDto);
    }


    public UserDto getUserInfo(UserDto userDto) {
        return userRepository.findByUsernameAndPassword(userDto.getUsername(), userDto.getPassword());
    }

    public UserDto getUserInfoByName(String username) {

        return userRepository.findByUsername(username);
    }
}
