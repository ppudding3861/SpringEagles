package com.ohgiraffers.springeagles.global.auth.config;

import com.ohgiraffers.springeagles.global.error.CustomAccessDeniedHandler;
import com.ohgiraffers.springeagles.global.auth.service.CustomUserDetailsService;
import com.ohgiraffers.springeagles.global.auth.util.CustomLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends GlobalMethodSecurityConfiguration {

    // GlobalMethodSecurityConfiguration : 스프링 시큐리티(Spring Security) 프레임워크에서 메서드 수준의 보안을 설정하기 위해 사용되는 중요한 구성 요소

    /*
     *  prePostEnabled = true: @PreAuthorize 및 @PostAuthorize 애노테이션을 사용하여 메서드 호출 전후에 보안 검사를 수행할 수 있습니다.
     *  securedEnabled = true: @Secured 애노테이션을 사용하여 특정 역할을 가진 사용자만 메서드를 호출할 수 있도록 설정합니다.
     *  jsr250Enabled = true: @RolesAllowed 애노테이션을 사용하여 JSR-250 표준 기반의 역할 기반 접근 제어를 설정합니다.
     */

    private final CustomUserDetailsService userDetailsService;
    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final PasswordEncoder passwordEncoder;
    private final CustomLoginSuccessHandler customLoginSuccessHandler;

    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService,
                          CustomAccessDeniedHandler accessDeniedHandler,
                          PasswordEncoder passwordEncoder,
                          CustomLoginSuccessHandler customLoginSuccessHandler) {
        this.userDetailsService = userDetailsService;
        this.accessDeniedHandler = accessDeniedHandler;
        this.passwordEncoder = passwordEncoder;
        this.customLoginSuccessHandler = customLoginSuccessHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/signup", "/css/**", "/javascript/**", "/images/**").permitAll()
                                .requestMatchers("/user/**").hasAuthority("ROLE_USER")
                                .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                                .requestMatchers("/stj/blog/**").hasAuthority("ROLE_STJ")
                                .requestMatchers("/sej/blog/**").hasAuthority("ROLE_SEJ")
                                .requestMatchers("/khs/blog/**").hasAuthority("ROLE_KHS")
                                .requestMatchers("/kkh/blog/**").hasAuthority("ROLE_KKH")
                                .requestMatchers("/lsh/blog/**").hasAuthority("ROLE_LSH")
                                .requestMatchers("/hjh/blog/**").hasAuthority("ROLE_HJH")
                                .anyRequest().authenticated())
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .successHandler(customLoginSuccessHandler)  // 커스텀 성공 핸들러 사용
                                .permitAll())
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/login?logout")
                                .permitAll())
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling
                                .accessDeniedHandler(accessDeniedHandler));

        return http.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}
