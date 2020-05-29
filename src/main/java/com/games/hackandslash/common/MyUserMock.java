package com.games.hackandslash.common;

public enum MyUserMock {
    CURRENT_LOGIN_MOCK("mczarny");

    private final String login;

    MyUserMock(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
