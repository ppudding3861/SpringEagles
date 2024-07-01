package com.ohgiraffers.springeagles.global.user.service;

import com.ohgiraffers.springeagles.global.user.repository.UserEntity;
import com.ohgiraffers.springeagles.global.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당이름의 유저를 찾을수 없습니다: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserName())
                .password(user.getUserPassword())
                .roles("USER")
                .build();
    }
}
