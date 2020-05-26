package com.games.hackandslash.logic;

import com.games.hackandslash.common.GameStatus;
import com.games.hackandslash.model.*;
import com.games.hackandslash.service.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.games.hackandslash.util.DefaultHero.LADY_ARIBETH;
import static com.games.hackandslash.util.DefaultHero.SAVEROK;
import static com.games.hackandslash.util.DefaultItem.*;
import static com.games.hackandslash.util.DefaultProfession.*;
import static com.games.hackandslash.util.DefaultTeam.TEAM_ONE;
import static com.games.hackandslash.util.DefaultTeam.TEAM_TWO;
import static com.games.hackandslash.util.DefaultUser.JBEDNARCZYK;
import static com.games.hackandslash.util.DefaultUser.MCZARNY;

@Component
public class DefaultDataGenerator implements InitializingBean {
    @Autowired
	ProfessionService professionService;
    @Autowired
	ItemService itemService;
	@Autowired
	UserService userService;
	@Autowired
	HeroService heroService;
	@Autowired
	TeamService teamService;
	@Autowired
	GameService gameService;

	public List<Profession> generateProfessions() {
        List<Profession> entities = new ArrayList<>();
        entities.add(PALADIN.getProfession());
		entities.add(RANGER.getProfession());
		entities.add(WARRIOR.getProfession());
		entities.add(WIZARD.getProfession());

		professionService.addAll(entities);

		return entities;
    }

	public List<Item> generateItems() {
		List<Item> entities = new ArrayList<>();
		entities.add(SWORD.getItem());
		entities.add(POTION.getItem());
		entities.add(BOW.getItem());
		entities.add(FULL_PLATE_ARMOR.getItem());
		entities.add(PLATE_ARMOR.getItem());
		entities.add(HAUBERK.getItem());
		entities.add(CLOAK.getItem());
		entities.add(MAGIC_BULLET.getItem());
		entities.add(HEALING.getItem());

		itemService.addAll(entities);

		return entities;
	}

	public List<User> generateUsers() {
		List<User> entities = new ArrayList<>();
		entities.add(MCZARNY.getUser());
		entities.add(JBEDNARCZYK.getUser());

		userService.addAll(entities);

		return entities;
	}

	public List<Team> generateTeams() {
		List<Team> entities = new ArrayList<>();
		User mczarny = userService.findByLogin("mczarny");
		entities.add(TEAM_ONE.getTeam(mczarny));
		User jbednarczyk = userService.findByLogin("jbednarczyk");
		entities.add(TEAM_TWO.getTeam(jbednarczyk));

		teamService.addAll(entities);

		return entities;
	}

	public void generateGame() {
		gameService.add(Game.builder().gameStatus(GameStatus.START).name("test").build());
	}

	public void generateHeroes() {
		List<Hero> entities = new ArrayList<>();
		Profession warrior = professionService.findByName("Warrior");
		Team teamOne = teamService.findByUserLogin("mczarny");
		entities.add(SAVEROK.getHero(warrior, teamOne, getSaverokEquipment()));
		Profession paladin = professionService.findByName("Paladin");
		Team teamTwo = teamService.findByUserLogin("jbednarczyk");
		entities.add(LADY_ARIBETH.getHero(paladin, teamTwo, getAribethEquipment()));

		heroService.addAll(entities);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		List<Profession> professions = generateProfessions();
		List<Item> items = generateItems();
		List<User> users = generateUsers();
		List<Team> teams = generateTeams();
		generateGame();
		generateHeroes();
	}

	private Item getItem(String name) {
		return itemService.findByName(name);
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
