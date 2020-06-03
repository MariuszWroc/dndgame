package com.games.hackandslash.mapper;

import com.games.hackandslash.dto.HeroCharacter;
import com.games.hackandslash.model.Hero;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HeroMapperTest {
    private HeroMapper mapper;
    protected HeroCharacter heroCharacterMock;
    protected Hero heroMock;

    @BeforeAll
    public void setup(){
        mapper = new HeroMapper();
        heroCharacterMock = new HeroCharacter();
        heroMock = new Hero();
    }

    @Test
    public void dtoToEntity() {
        Hero hero = mapper.dtoToEntity(heroCharacterMock);
        assertEquals(hero, heroMock);
    }

    @Test
    public void entityToDto() {
        HeroCharacter heroCharacter = mapper.entityToDto(heroMock);
        assertEquals(heroCharacter, heroCharacterMock);
    }
}
