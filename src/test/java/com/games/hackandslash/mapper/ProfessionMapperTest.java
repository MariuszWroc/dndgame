package com.games.hackandslash.mapper;

import com.games.hackandslash.dto.ProfessionDto;
import com.games.hackandslash.model.Profession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProfessionMapperTest {
    private ProfessionMapper mapper = new ProfessionMapper();
    protected ProfessionDto ProfessionDtoMock;
    protected Profession ProfessionMock;

    @BeforeAll
    public void setup(){
        mapper = new ProfessionMapper();
    }

    @Test
    public void dtoToEntity() {
        Profession profession = mapper.dtoToEntity(ProfessionDtoMock);
        assertEquals(profession, ProfessionDtoMock);
    }

    @Test
    public void entityToDto() {
        ProfessionDto dto = mapper.entityToDto(ProfessionMock);
        assertEquals(dto, ProfessionMock);
    }
}
