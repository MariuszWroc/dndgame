package com.games.hackandslash.dto;

import java.util.Set;

public class GameSession extends GameCreator{
    private Set<String> allAvailablePlayers;
    private Set<String> allAvailableGames;
    private String ownerPlayer;
    private String fellowPlayer;
    private String status;
}
