package com.games.hackandslash.mapper;

import com.games.hackandslash.dto.ProfessionDto;
import com.games.hackandslash.model.Profession;

public class ProfessionMapper implements DtoMapper<Profession, ProfessionDto> {
    @Override
    public Profession dtoToEntity(ProfessionDto dto) {
        return DtoMapper.modelMapper().map(dto, Profession.class);
    }

    @Override
    public ProfessionDto entityToDto(Profession entity) {
        return DtoMapper.modelMapper().map(entity, ProfessionDto.class);
    }
}
