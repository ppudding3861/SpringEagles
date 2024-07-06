package com.ohgiraffers.springeagles.global.auth.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

// 세션 메세지 관리 컨트롤러
@Component
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException, ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("username", authentication.getName());
        session.setAttribute("loginSuccess", true);

        // 원래의 기본 성공 URL로 리다이렉트
        super.onAuthenticationSuccess(request, response, authentication);
    }
}