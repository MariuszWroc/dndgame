package com.games.hackandslash.logic;

import com.games.hackandslash.common.GameStatus;
import com.games.hackandslash.model.*;
import com.games.hackandslash.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

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

	public List<Profession> generateProfessions() {
        List<Profession> entities = new ArrayList<>();
        entities.add(PALADIN.getProfession());
		entities.add(RANGER.getProfession());
		entities.add(WARRIOR.getProfession());
		entities.add(WIZARD.getProfession());

		professionRepository.saveAll(entities);

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

		itemRepository.saveAll(entities);

		return entities;
	}

	public List<User> generateUsers() {
		List<User> entities = new ArrayList<>();
		entities.add(MCZARNY.getUser());
		entities.add(JBEDNARCZYK.getUser());

		userRepository.saveAll(entities);

		return entities;
	}

	public List<Team> generateTeams(List<User> users) {
		List<Team> entities = new ArrayList<>();
		entities.add(TEAM_ONE.getTeam(generateTeamOne(), users.get(0)));
		entities.add(TEAM_TWO.getTeam(generateTeamTwo(), users.get(1)));

		teamRepository.saveAll(entities);

		return entities;
	}

	public void generateGame(User owner, User fellow, String name) {
		gameRepository.save(Game.builder().gameStatus(GameStatus.START).name(name)
				.owner(owner).fellow(fellow).build());
	}

	public Set<Hero> generateTeamOne() {
		Set<Hero> entities = new HashSet<>();
		Profession warrior = professionRepository.findByName("Warrior");
		entities.add(SAVEROK.getHero(warrior, getSaverokEquipment()));

		heroRepository.saveAll(entities);

		return entities;
	}

	public Set<Hero> generateTeamTwo() {
		Set<Hero> entities = new HashSet<>();
		Profession paladin = professionRepository.findByName("Paladin");
		entities.add(LADY_ARIBETH.getHero(paladin, getAribethEquipment()));

		heroRepository.saveAll(entities);

		return entities;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		generateProfessions();
		List<User> users = generateUsers();
		generateItems();
		generateGame(users.get(0), users.get(1), "test1");
		generateGame(users.get(1), null, "test2");
		generateTeams(users);
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
