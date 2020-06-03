package com.games.hackandslash.util;

import com.games.hackandslash.model.Hero;
import com.games.hackandslash.model.Team;
import com.games.hackandslash.model.User;

import java.util.Set;

public enum DefaultTeam {
    TEAM_ONE {
        @Override
        public Team getTeam(Set<Hero> heroes, User user) {
            return Team.builder().money(150).heroes(heroes).user(user).build();
        }
    },
    TEAM_TWO {
        @Override
        public Team getTeam(Set<Hero> heroes, User user) {
            return Team.builder().money(100).heroes(heroes).user(user).build();
        }
    };

    public abstract Team getTeam(Set<Hero> heroes, User user);
}
