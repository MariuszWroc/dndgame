package com.games.hackandslash.dto;

import lombok.*;

import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class HeroCharacter {
    private String name;
    private String gender;
    private String race;
    private String profession;
    private Integer speed;
    private Integer baseHP;
    private Integer currentHP;
    private Integer baseAC;
    private List<ItemDto> backpack;
    private ItemDto armor;
    private ItemDto weapon;
    private List<ItemDto> charms;
}
