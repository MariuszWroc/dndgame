package com.games.hackandslash.mapper;

import com.games.hackandslash.dto.GameSession;
import com.games.hackandslash.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameSessionMapper implements DtoMapper<Game, GameSession>{

    @Override
    public Game dtoToEntity(GameSession dto) {
        return DtoMapper.modelMapper().map(dto, Game.class);
    }

    @Override
    public GameSession entityToDto(Game entity) {
        return DtoMapper.modelMapper().map(entity, GameSession.class);
    }
}
