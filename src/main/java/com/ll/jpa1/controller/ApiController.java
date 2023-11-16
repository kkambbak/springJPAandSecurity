package com.ll.jpa1.controller;

import com.ll.jpa1.dto.TokenDto;
import com.ll.jpa1.dto.UserDto;
import com.ll.jpa1.jwt.TokenProvider;
import com.ll.jpa1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api")
public class ApiController {

    private final UserService userService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

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

    @PostMapping("/login")
    public HashMap<String, Object> login(@RequestBody UserDto userDto){
        HashMap<String, Object> map = new HashMap<>();

        //중복 체크
        UserDto resultDto = userService.getUserInfo(userDto);

        if(resultDto==null){
            map.put("result", "fail");
            map.put("msg", userDto.getUsername()+"에 해당하는 사용자를 찾을 수 없습니다.");
            return map;
        }
        //2. 토큰발행
        //3. 다른 필터들에게 통과되었음을 알려야한다. SecurityContext 인증정보를 넣어놔야 함.
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        userDto.getUsername(),
                        userDto.getPassword());

        Authentication authentication =
                authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        TokenDto tokenDto = tokenProvider.createToken(authentication);

        map.put("result", "success");
        map.put("accessToken", tokenDto.getAccess_token());
        map.put("refreshToken", tokenDto.getRefresh_token());

        return map;
    }
}
