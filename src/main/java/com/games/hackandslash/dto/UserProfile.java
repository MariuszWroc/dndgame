package com.games.hackandslash.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserProfile {
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String email;
}
