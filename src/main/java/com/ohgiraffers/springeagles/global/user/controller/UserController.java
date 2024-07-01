package com.ohgiraffers.springeagles.global.user.controller;

import com.ohgiraffers.springeagles.global.user.repository.UserRepository;
import com.ohgiraffers.springeagles.global.user.repository.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserController(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignupForm(@ModelAttribute("user") @Valid UserEntity user, BindingResult result, Model model) {
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
        userRepository.save(user);

        return "redirect:/login"; // 회원 가입 성공 시 로그인 페이지로 이동
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}

