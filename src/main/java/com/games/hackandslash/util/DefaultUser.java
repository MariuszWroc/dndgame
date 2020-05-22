package com.games.hackandslash.util;

import com.games.hackandslash.common.RoleName;
import com.games.hackandslash.model.User;

public enum DefaultUser {
    MCZARNY{
        @Override
        public User getUser() {
            return User.builder().activated(true).email("mariusz@mariusz.pl").firstname("Mariusz").lastname("Czarny")
                    .login("mczarny").role(RoleName.ADMIN).password("alamakota").build();
        }
    },
    JBEDNARCZYK {
        @Override
        public User getUser() {
            return User.builder().activated(true).email("jacek@jacek.pl").firstname("Jacek").lastname("Bednarczyk")
                    .login("jbednarczyk").role(RoleName.ADMIN).password("alamakota").build();
        }
    };

    public abstract User getUser();
}
