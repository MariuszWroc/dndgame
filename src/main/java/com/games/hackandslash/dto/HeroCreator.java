package com.games.hackandslash.dto;

import com.games.hackandslash.model.Item;
import com.games.hackandslash.model.Profession;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class HeroCreator {
    private Integer speed;
    private String name;
    private Integer gender;
    private Integer race;
    private Profession profession;
    private Integer baseHP;
    private Integer currentHP;
    private Integer baseAC;
    private List<Item> backpack;
    private Item armor;
    private Item weapon;
    private List<Item> charms;
}
