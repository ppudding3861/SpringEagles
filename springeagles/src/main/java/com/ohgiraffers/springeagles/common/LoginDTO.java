package com.ohgiraffers.springeagles.common;

/*
 * DTO를 작성 할 때 커멘드 객체로 이용하기 위해서는 FORM의 name과 필드가 일치하게 만들어야 한다.
 * */

public class LoginDTO {

    private String name;

    private String loginStatus;

    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String name, String loginStatus, String password) {
        this.name = name;
        this.loginStatus = loginStatus;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "name='" + name + '\'' +
                ", loginStatus='" + loginStatus + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
