package com.games.hackandslash.mapper;

import com.games.hackandslash.dto.HeroCreator;
import com.games.hackandslash.model.Hero;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HeroMapperTest {
    private HeroMapper mapper = new HeroMapper();
    protected HeroCreator heroCreatorMock;
    protected Hero heroMock;

    @BeforeAll
    public void setup(){
        mapper = new HeroMapper();
    }

    @Test
    public void dtoToEntity() {
        Hero hero = mapper.dtoToEntity(heroCreatorMock);
        assertEquals(hero, heroMock);
    }

    @Test
    public void entityToDto() {
        HeroCreator heroCreator = mapper.entityToDto(heroMock);
        assertEquals(heroCreator, heroMock);
    }
}
