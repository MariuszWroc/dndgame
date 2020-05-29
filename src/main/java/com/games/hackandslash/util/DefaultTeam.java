package com.games.hackandslash.util;

import com.games.hackandslash.model.Hero;
import com.games.hackandslash.model.Team;

import java.util.Set;

public enum DefaultTeam {
    TEAM_ONE {
        @Override
        public Team getTeam(Set<Hero> heroes) {
            return Team.builder().money(150).heroes(heroes).build();
        }
    },
    TEAM_TWO {
        @Override
        public Team getTeam(Set<Hero> heroes) {
            return Team.builder().money(100).heroes(heroes).build();
        }
    };

    public abstract Team getTeam(Set<Hero> heroes);
}
