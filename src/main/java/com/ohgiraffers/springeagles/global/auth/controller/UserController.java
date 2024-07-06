package com.ohgiraffers.springeagles.global.auth.controller;

import com.ohgiraffers.springeagles.global.auth.model.UserRole;
import com.ohgiraffers.springeagles.global.auth.repository.UserRepository;
import com.ohgiraffers.springeagles.global.auth.entity.UserEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserController(PasswordEncoder passwordEncoder,
                          UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String loginPage(HttpSession session, Model model) {
        Boolean successMessage = (Boolean) session.getAttribute("successMessage");
        if (Boolean.TRUE.equals(successMessage)) {
            model.addAttribute("successMessage", true);
            session.removeAttribute("successMessage");
        } else {
            model.addAttribute("successMessage", false);
        }
        return "login";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignupForm(@ModelAttribute("user") @Valid UserEntity user, BindingResult result, Model model, HttpSession session) {
        // 사용자 이름 중복 검사
        UserEntity existingUser = userRepository.findByUserName(user.getUserName()).orElse(null);
        if (existingUser != null) {
            model.addAttribute("IdError", "이미 사용 중인 사용자 이름입니다.");
            return "signup"; // 중복 발생 시 회원 가입 페이지 다시 표시
        }

        // 이메일 중복 검사
        existingUser = userRepository.findByUserEmail(user.getUserEmail()).orElse(null);
        if (existingUser != null) {
            model.addAttribute("EmailError", "이미 등록된 이메일 주소입니다.");
            return "signup"; // 중복 발생 시 회원 가입 페이지 다시 표시
        }

        // 비밀번호 암호화 후 저장
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

        // 기본 역할 설정
        // 사용자가 역할을 설정하지 않은 경우
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            // 기본 역할을 USER로 설정합니다.
            user.setRoles(Collections.singleton(UserRole.USER));
        }

        userRepository.save(user);

        // 세션에 성공 메시지 저장
        session.setAttribute("successMessage", true);

        return "redirect:/login"; // 회원 가입 성공 시 로그인 페이지로 이동
    }
}
