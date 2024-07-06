package com.ohgiraffers.springeagles.global.auth.service;

import com.ohgiraffers.springeagles.global.auth.entity.UserEntity;
import com.ohgiraffers.springeagles.global.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("회원을 찾을수 없습니다"));

        Set<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toSet());

        return new User(user.getUserName(), user.getUserPassword(), authorities);
    }

    public Optional<UserEntity> findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
}
