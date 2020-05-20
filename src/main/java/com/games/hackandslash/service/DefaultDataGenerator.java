package com.games.hackandslash.service;

import com.games.hackandslash.model.Item;
import com.games.hackandslash.model.Profession;
import com.games.hackandslash.model.User;
import com.games.hackandslash.repository.ItemRepository;
import com.games.hackandslash.repository.ProfessionRepository;
import com.games.hackandslash.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.games.hackandslash.util.DefaultItem.*;
import static com.games.hackandslash.util.DefaultProfession.*;
import static com.games.hackandslash.util.DefaultUser.JBEDNARCZYK;
import static com.games.hackandslash.util.DefaultUser.MCZARNY;

@Service
public class DefaultDataGenerator implements InitializingBean {
    @Autowired
    ProfessionRepository professionRepository;
    @Autowired
    ItemRepository itemRepository;
	@Autowired
	UserRepository userRepository;

    public void generateProfessions() {
        List<Profession> entities = new ArrayList<>();
        entities.add(PALADIN.getProfession());
		entities.add(RANGER.getProfession());
		entities.add(WARRIOR.getProfession());
		entities.add(WIZARD.getProfession());

		professionRepository.saveAll(entities);
    }

	public void generateItems() {
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
	}

	public void generateUsers() {
		List<User> entities = new ArrayList<>();
		entities.add(MCZARNY.getUser());
		entities.add(JBEDNARCZYK.getUser());

		userRepository.saveAll(entities);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		generateProfessions();
		generateItems();
		generateUsers();
	}
}
