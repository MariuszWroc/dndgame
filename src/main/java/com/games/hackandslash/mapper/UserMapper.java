package com.games.hackandslash.mapper;


import com.games.hackandslash.dto.UserProfile;
import com.games.hackandslash.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements DtoMapper<User, UserProfile> {
    @Override
    public User dtoToEntity(UserProfile dto) {
        return DtoMapper.modelMapper().map(dto, User.class);
    }

    @Override
    public UserProfile entityToDto(User entity) {
        return DtoMapper.modelMapper().map(entity, UserProfile.class);
    }
}
