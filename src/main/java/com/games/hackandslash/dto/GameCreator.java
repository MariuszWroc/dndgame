package com.games.hackandslash.dto;

import lombok.*;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class GameCreator {
    private String name;
    private String ownerLogin;
}
