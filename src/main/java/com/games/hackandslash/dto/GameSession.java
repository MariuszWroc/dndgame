package com.games.hackandslash.dto;

import lombok.*;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class GameSession {
    private String name;
    private String ownerLogin;
    private String fellowLogin;
    private String status;
    private Integer round = 0;
}
