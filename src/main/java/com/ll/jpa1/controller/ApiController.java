package com.ll.jpa1.controller;

import com.ll.jpa1.dto.UserDto;
import com.ll.jpa1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api")
public class ApiController {

    private final UserService userService;

    @GetMapping("/hello")
    public HashMap<String, Object> hello(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", "ok");
        map.put("msg", "Hello");
        return map;
    }

    @PostMapping("/signup")
    public HashMap<String, Object> signup(@RequestBody UserDto userDto){

        HashMap<String, Object> map = new HashMap<>();

        userService.userRegister(userDto);

        map.put("result", "ok");
        map.put("msg", userDto.getUsername()+"님 회원가입을 축하드립니다.");
        return map;
    }
}
