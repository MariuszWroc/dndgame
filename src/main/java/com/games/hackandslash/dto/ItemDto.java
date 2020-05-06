package com.games.hackandslash.dto;

import com.games.hackandslash.model.Category;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ItemDto {
    private String name;
    private Category category;
    private Integer attack;
    private Integer defend;
    private Integer magic;
    private Integer addHealth;
    private Integer addStrength;
    private Integer addDexterity;
    private Integer addConstitution;
    private Integer addIntelligence;
    private Integer amount;
}
