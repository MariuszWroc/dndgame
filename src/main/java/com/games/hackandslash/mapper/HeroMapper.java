package com.games.hackandslash.mapper;

import com.games.hackandslash.dto.HeroCreator;
import com.games.hackandslash.model.Hero;
import org.springframework.stereotype.Service;

@Service
public class HeroMapper implements DtoMapper<Hero, HeroCreator> {

    @Override
    public Hero dtoToEntity(HeroCreator dto) {
        return DtoMapper.modelMapper().map(dto, Hero.class);
    }

    @Override
    public HeroCreator entityToDto(Hero entity) {
        return DtoMapper.modelMapper().map(entity, HeroCreator.class);
    }
}
