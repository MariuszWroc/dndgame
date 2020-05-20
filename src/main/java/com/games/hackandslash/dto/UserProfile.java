package com.games.hackandslash.dto;

import lombok.*;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class UserProfile {
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String email;
}
