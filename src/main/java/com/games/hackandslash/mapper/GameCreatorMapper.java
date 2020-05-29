package com.games.hackandslash.mapper;

import com.games.hackandslash.dto.GameCreator;
import com.games.hackandslash.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameCreatorMapper implements DtoMapper<Game, GameCreator>{

    @Override
    public Game dtoToEntity(GameCreator dto) {
        return DtoMapper.modelMapper().map(dto, Game.class);
    }

    @Override
    public GameCreator entityToDto(Game entity) {
        return DtoMapper.modelMapper().map(entity, GameCreator.class);
    }
}
