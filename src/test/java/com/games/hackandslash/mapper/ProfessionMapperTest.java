package com.games.hackandslash.mapper;

import com.games.hackandslash.dto.ProfessionDto;
import com.games.hackandslash.model.Profession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProfessionMapperTest {
    private ProfessionMapper mapper;
    protected ProfessionDto ProfessionDtoMock;
    protected Profession ProfessionMock;

    @BeforeAll
    public void setup(){
        mapper = new ProfessionMapper();
        ProfessionDtoMock = ProfessionDto.builder().name("Warrior").strength(18).dexterity(14).constitution(16)
        .intelligence(11).build();
        ProfessionMock = Profession.builder().id(null).name("Warrior").strength(18).dexterity(14).constitution(16)
                .intelligence(11).heroes(null).build();
    }

    @Test
    public void dtoToEntity() {
        Profession profession = mapper.dtoToEntity(ProfessionDtoMock);
        assertEquals(profession, ProfessionMock);
    }

    @Test
    public void entityToDto() {
        ProfessionDto dto = mapper.entityToDto(ProfessionMock);
        assertEquals(dto, ProfessionDtoMock);
    }
}
