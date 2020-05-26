package com.games.hackandslash.util;

import com.games.hackandslash.model.Team;
import com.games.hackandslash.model.User;

public enum DefaultTeam {
    TEAM_ONE {
        @Override
        public Team getTeam(User user) {
            return Team.builder().money(150).user(user).build();
        }
    },
    TEAM_TWO {
        @Override
        public Team getTeam(User user) {
            return Team.builder().money(100).user(user).build();
        }
    };

    public abstract Team getTeam(User user);
}
