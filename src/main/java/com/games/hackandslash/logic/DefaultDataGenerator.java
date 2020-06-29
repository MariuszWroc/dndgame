package com.games.hackandslash.logic;

import com.games.hackandslash.model.Item;
import com.games.hackandslash.model.Profession;
import com.games.hackandslash.repository.ItemRepository;
import com.games.hackandslash.repository.ProfessionRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.games.hackandslash.util.DefaultItem.*;
import static com.games.hackandslash.util.DefaultProfession.*;

@Component
public class DefaultDataGenerator implements InitializingBean {
    @Autowired
	ProfessionRepository professionRepository;
    @Autowired
	ItemRepository itemRepository;

	private List<Profession> generateProfessions() {
        List<Profession> entities = new ArrayList<>();
        entities.add(PALADIN.getProfession());
		entities.add(RANGER.getProfession());
		entities.add(WARRIOR.getProfession());
		entities.add(WIZARD.getProfession());

		professionRepository.saveAll(entities);

		return entities;
    }

	private List<Item> generateItems() {
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

	@Override
	public void afterPropertiesSet() throws Exception {
		generateProfessions();
		generateItems();
	}

}
