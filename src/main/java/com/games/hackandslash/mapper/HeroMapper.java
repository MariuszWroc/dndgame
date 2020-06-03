package com.games.hackandslash.mapper;

import com.games.hackandslash.dto.HeroCharacter;
import com.games.hackandslash.model.Hero;
import org.springframework.stereotype.Component;

@Component
public class HeroMapper implements DtoMapper<Hero, HeroCharacter> {

    @Override
    public Hero dtoToEntity(HeroCharacter dto) {
        return DtoMapper.modelMapper().map(dto, Hero.class);
    }

    @Override
    public HeroCharacter entityToDto(Hero entity) {
        return DtoMapper.modelMapper().map(entity, HeroCharacter.class);
    }
}
