package com.games.hackandslash.util;

import com.games.hackandslash.common.Gender;
import com.games.hackandslash.common.Race;
import com.games.hackandslash.model.*;

import java.util.List;

public enum DefaultHero {
    SAVEROK {
        @Override
        public Hero getHero(Profession profession, List<Item> items) {
            return Hero.builder().name("Saverok").gender(Gender.MALE).baseAC(5).baseHP(20).currentHP(20)
                    .speed(3).race(Race.HUMAN).profession(profession)
                    .items(items).build();
        }
    },
    LADY_ARIBETH {
        @Override
        public Hero getHero(Profession profession, List<Item> items) {
            return Hero.builder().name("Lady Aribeth").gender(Gender.FEMALE).baseAC(8).baseHP(30).currentHP(30)
                    .speed(4).race(Race.ELF).profession(profession)
                    .items(items).build();
        }
    };

    public abstract Hero getHero(Profession profession, List<Item> items);
}
