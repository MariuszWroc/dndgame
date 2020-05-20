package com.games.hackandslash.mapper;

import com.games.hackandslash.dto.UserProfile;
import com.games.hackandslash.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserMapperTest {
    private UserMapper mapper;
    protected UserProfile userProfileMock;
    protected User userMock;

    @BeforeAll
    public void setup(){
        mapper = new UserMapper();
        userProfileMock = UserProfile.builder().firstname("Mariusz").lastname("Czarny")
                .email("mariusz@gmail.com").login("mczarny")
                .password("123").build();
        userMock = User.builder().id(null).firstname("Mariusz").lastname("Czarny")
                .email("mariusz@gmail.com").login("mczarny").role(null).activated(null)
                .password("123").build();
    }

    @Test
    public void dtoToEntity() {
        User userActual = mapper.dtoToEntity(userProfileMock);
        assertEquals(userActual, userMock);
    }

    @Test
    public void entityToDto() {
        UserProfile userProfileActual = mapper.entityToDto(userMock);
        assertEquals(userProfileActual, userProfileMock);
    }
}