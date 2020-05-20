package com.games.hackandslash.util;

import com.games.hackandslash.model.Profession;

public enum DefaultProfession {
    WARRIOR {
        @Override
        public Profession getProfession() {
            return Profession.builder().name("Warrior").strength(18).dexterity(12).constitution(15).intelligence(8).build();
        }
    },
    WIZARD {
        @Override
        public Profession getProfession() {
            return Profession.builder().name("Wizard").strength(10).dexterity(12).constitution(12).intelligence(18).build();
        }
    },
    RANGER {
        @Override
        public Profession getProfession() {
            return Profession.builder().name("Ranger").strength(14).dexterity(17).constitution(16).intelligence(10).build();
        }
    },
    PALADIN {
        @Override
        public Profession getProfession() {
            return Profession.builder().name("Paladin").strength(16).dexterity(13).constitution(14).intelligence(12).build();
        }
    };

    public abstract Profession getProfession();
}
