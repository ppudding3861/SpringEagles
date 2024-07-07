package com.ohgiraffers.springeagles.global.auth.util.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;


// 소개페이지 접근 권한이 없을 때 처리하는 핸들러
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("<script>alert('권한이 없습니다.'); window.history.back();</script>");
        response.getWriter().flush();
    }
}