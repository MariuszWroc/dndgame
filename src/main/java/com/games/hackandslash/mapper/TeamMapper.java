package com.games.hackandslash.mapper;

import com.games.hackandslash.dto.TeamSettings;
import com.games.hackandslash.model.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper implements DtoMapper<Team, TeamSettings> {
    @Override
    public Team dtoToEntity(TeamSettings dto) {
        return DtoMapper.modelMapper().map(dto, Team.class);
    }

    @Override
    public TeamSettings entityToDto(Team entity) {
        return DtoMapper.modelMapper().map(entity, TeamSettings.class);
    }
}
