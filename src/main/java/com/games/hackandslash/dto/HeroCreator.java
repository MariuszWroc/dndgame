package com.games.hackandslash.dto;

import com.games.hackandslash.common.Gender;
import com.games.hackandslash.common.Race;
import lombok.*;

import java.util.List;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class HeroCreator {
    private String name;
    private Gender gender;
    private List<Race> races;
    private List<ProfessionDto> professions;
    private List<ItemDto> otherItems;
    private List<ItemDto> armors;
    private List<ItemDto> weapons;
    private List<ItemDto> charms;
}
