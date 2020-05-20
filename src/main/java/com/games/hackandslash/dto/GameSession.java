package com.games.hackandslash.dto;

import lombok.*;

import java.util.Set;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class GameSession {
    private Set<UserProfile> availableUsers;
    private String name;
    private String status;
}
