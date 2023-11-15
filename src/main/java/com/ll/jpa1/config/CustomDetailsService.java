package com.ll.jpa1.config;

import com.ll.jpa1.dto.UserDto;
import com.ll.jpa1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("userDetailsService")
@RequiredArgsConstructor
public class CustomDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("1234")
//                .roles("USER")
//                .build();

        //디비로부터 UserDto객체를 가져오도록 변경
        UserDto userDto = userRepository.findByUsername(username);
        userDto.encodePassword(passwordEncoder.encode(userDto.getPassword()));
        CustomUserDetails userDetails = new CustomUserDetails(userDto);

        return userDetails;
    }
}
