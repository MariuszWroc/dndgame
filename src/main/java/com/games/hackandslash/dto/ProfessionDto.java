package com.games.hackandslash.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProfessionDto {
    private String name;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
}
