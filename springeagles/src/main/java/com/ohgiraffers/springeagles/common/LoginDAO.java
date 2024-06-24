package com.ohgiraffers.springeagles.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginDAO {

    private final Map<Integer, LoginDTO> loginMap;

    public LoginDAO() {
        loginMap = new HashMap<>();

        LoginDTO login1 = new LoginDTO("주순태","N","Spring1");
        LoginDTO login2 = new LoginDTO("서은진","N","Spring2");
        LoginDTO login3 = new LoginDTO("김기호","N","Spring3");
        LoginDTO login4 = new LoginDTO("강형석","N","Spring4");
        LoginDTO login5 = new LoginDTO("이서현","N","Spring5");
        LoginDTO login6 = new LoginDTO("황정한","N","Spring6");
        loginMap.put(1, login1);
        loginMap.put(2, login2);
        loginMap.put(3, login3);
        loginMap.put(4, login4);
        loginMap.put(5, login5);
        loginMap.put(6, login6);
    }
    public LoginDAO(Map<Integer, LoginDTO> loginMap) {
        this.loginMap = loginMap;
    }

    public List<LoginDTO> getAllLogin() {
        return new ArrayList<>(loginMap.values());
    }
}

