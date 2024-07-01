package com.ohgiraffers.springeagles.global.user.config;

import com.ohgiraffers.springeagles.global.user.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final PasswordEncoderConfig passwordEncoderConfig;

    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService, PasswordEncoderConfig passwordEncoderConfig) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoderConfig = passwordEncoderConfig;
    }

    // SecurityFilterChain을 설정하는 메서드
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // HttpSecurity를 사용하여 보안 구성
        http
                // CSRF 보호 비활성화
                .csrf(AbstractHttpConfigurer::disable)
                // 요청 권한 설정
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                // 특정 요청에 대해 인증 없이 접근 허용
                                .requestMatchers("/signup", "/css/**", "/js/**").permitAll()
                                // 그 외 모든 요청은 인증이 필요함
                                .anyRequest().authenticated())
                // 로그인 설정
                .formLogin(formLogin ->
                        formLogin
                                // 로그인 페이지 설정
                                .loginPage("/login")
                                // 로그인 성공 후 기본적으로 리다이렉트할 URL 설정
                                .defaultSuccessUrl("/", true)
                                // 로그인 페이지에 대해 인증 없이 접근 허용
                                .permitAll())
                // 로그아웃 설정
                .logout(logout ->
                        logout
                                // 로그아웃 URL 설정
                                .logoutUrl("/logout")
                                // 로그아웃 성공 후 리다이렉트할 URL 설정
                                .logoutSuccessUrl("/login?logout")
                                // 로그아웃 페이지에 대해 인증 없이 접근 허용
                                .permitAll());

        // 구성된 HttpSecurity를 반환하여 SecurityFilterChain을 구축
        return http.build();
    }

    // AuthenticationManagerBuilder를 사용하여 사용자 인증을 구성
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder((PasswordEncoder) passwordEncoderConfig);
    }
}
