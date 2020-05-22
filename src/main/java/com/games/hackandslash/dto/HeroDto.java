package com.games.hackandslash.dto;

import com.games.hackandslash.model.Item;
import lombok.*;

import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class HeroDto {
    private Integer speed;
    private String name;
    private Integer gender;
    private String race;
    private String profession;
    private Integer baseHP;
    private Integer currentHP;
    private Integer baseAC;
    private List<ItemDto> backpack;
    private Item armor;
    private Item weapon;
    private List<ItemDto> charms;
}
