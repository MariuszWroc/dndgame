package com.games.hackandslash.dto;

import lombok.*;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Battle {
    private String userLogin;
    private Long heroId;
    private String command;
    private Long enemyHeroId;
}
