package com.ohgiraffers.springeagles;



import com.ohgiraffers.springeagles.common.LoginDAO;
import com.ohgiraffers.springeagles.common.LoginDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("id")
public class LoginController {

    private final LoginDAO loginDAO;

    public LoginController() {
        this.loginDAO = new LoginDAO(); // LoginDAO 초기화
    }

    @GetMapping("login")
    public void login() {
    }


    /* 4-1. session이용하기
     * HttpSession을 매개변수로 선언하면 핸들러 메소드 호출 시 세션 객체를 넣어서 호출한다.
     * */
    @PostMapping("login1")
    public String sessionTest1(HttpSession session, @RequestParam String id, Model model) {
        session.setAttribute("id", id);

        List<LoginDTO> userList = loginDAO.getAllLogin();
        model.addAttribute("userList",userList);
        return "framnets/loginResult";


    }

    @GetMapping("logout1")
    public String logoutText1(HttpSession session) {
        session.invalidate();
        return "framnets/loginResult";
    }
}
