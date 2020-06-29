package com.games.hackandslash.logic;

import com.games.hackandslash.model.*;
import com.games.hackandslash.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.games.hackandslash.util.DefaultHero.LADY_ARIBETH;
import static com.games.hackandslash.util.DefaultHero.SAVEROK;
import static com.games.hackandslash.util.DefaultTeam.TEAM_ONE;
import static com.games.hackandslash.util.DefaultTeam.TEAM_TWO;
import static com.games.hackandslash.util.DefaultUser.JBEDNARCZYK;
import static com.games.hackandslash.util.DefaultUser.MCZARNY;
import static com.games.hackandslash.common.GameStatus.START;

@Component
@DependsOn("defaultDataGenerator")
public class CustomMockGenerator implements InitializingBean {
    @Autowired
    ProfessionRepository professionRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    HeroRepository heroRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    GameRepository gameRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<User> users = generateUsers();
        generateGame(users.get(0), users.get(1), "test1");
        generateGame(users.get(1), null, "test2");
        generateTeams(users);

    }

    private List<User> generateUsers() {
        List<User> entities = new ArrayList<>();
        entities.add(MCZARNY.getUser());
        entities.add(JBEDNARCZYK.getUser());

        userRepository.saveAll(entities);

        return entities;
    }

    private List<Team> generateTeams(List<User> users) {
        List<Team> entities = new ArrayList<>();
        entities.add(TEAM_ONE.getTeam(generateTeamOne(), users.get(0)));
        entities.add(TEAM_TWO.getTeam(generateTeamTwo(), users.get(1)));

        teamRepository.saveAll(entities);

        return entities;
    }

    private void generateGame(User owner, User fellow, String name) {
        gameRepository.save(Game.builder().gameStatus(START).name(name)
                .owner(owner).fellow(fellow).build());
    }

    private Set<Hero> generateTeamOne() {
        Set<Hero> entities = new HashSet<>();
        Profession warrior = professionRepository.findByName("Warrior");
        entities.add(SAVEROK.getHero(warrior, getSaverokEquipment()));

        heroRepository.saveAll(entities);

        return entities;
    }

    private Set<Hero> generateTeamTwo() {
        Set<Hero> entities = new HashSet<>();
        Profession paladin = professionRepository.findByName("Paladin");
        entities.add(LADY_ARIBETH.getHero(paladin, getAribethEquipment()));

        heroRepository.saveAll(entities);

        return entities;
    }

    private Item getItem(String name) {
        return itemRepository.findByName(name);
    }

    private List<Item> getSaverokEquipment() {
        List<Item> saverokItems = new ArrayList<>();
        saverokItems.add(getItem("Sword"));
        saverokItems.add(getItem("Plate armor"));
        Item potion = getItem("Potion");
        saverokItems.add(potion);
        saverokItems.add(potion);

        return saverokItems;
    }


    private List<Item> getAribethEquipment() {
        List<Item> aribethItems = new ArrayList<>();
        aribethItems.add(getItem("Sword"));
        aribethItems.add(getItem("Hauberk"));
        Item potion = getItem("Potion");
        aribethItems.add(potion);
        aribethItems.add(getItem("Magic bullet"));

        return aribethItems;
    }
}
