package com.games.hackandslash.service;

import com.games.hackandslash.model.Item;
import com.games.hackandslash.model.Profession;
import com.games.hackandslash.model.RoleName;
import com.games.hackandslash.model.User;
import com.games.hackandslash.repository.ItemRepository;
import com.games.hackandslash.repository.ProfessionRepository;
import com.games.hackandslash.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenerateDefaultData implements InitializingBean {
    @Autowired
    ProfessionRepository professionRepository;
    @Autowired
    ItemRepository itemRepository;
	@Autowired
	UserRepository userRepository;

    public void generateProfessions() {
        List<Profession> entities = new ArrayList<>();
        entities.add(Profession.builder().name("Warrior").strength(18).dexterity(12).constitution(15).intelligence(8).build());
		entities.add(Profession.builder().name("Wizard").strength(10).dexterity(12).constitution(12).intelligence(18).build());
		entities.add(Profession.builder().name("Ranger").strength(14).dexterity(17).constitution(16).intelligence(10).build());
		entities.add(Profession.builder().name("Paladin").strength(16).dexterity(13).constitution(14).intelligence(12).build());

		professionRepository.saveAll(entities);
    }

	public void generateItems() {
		List<Item> entities = new ArrayList<>();
		entities.add(Item.builder().name("Sword").build());
		entities.add(Item.builder().name("Potion").build());
		entities.add(Item.builder().name("Bow").build());
		entities.add(Item.builder().name("Full plate armor").build());
		entities.add(Item.builder().name("Plate armor").build());
		entities.add(Item.builder().name("Hauberk").build());
		entities.add(Item.builder().name("Cloak").build());
		entities.add(Item.builder().name("Magic bullet").build());
		entities.add(Item.builder().name("Healing").build());

		itemRepository.saveAll(entities);
	}

	public void generateUsers() {
		List<User> entities = new ArrayList<>();
		entities.add(User.builder().activated(true).email("mariusz@mariusz.pl").firstname("Mariusz").lastname("Czarny")
				.login("mczarny").role(RoleName.ADMIN).password("alamakota").build());
		entities.add(User.builder().activated(true).email("jacek@jacek.pl").firstname("Jacek").lastname("Bednarczyk")
				.login("jbednarczyk").role(RoleName.ADMIN).password("alamakota").build());

		userRepository.saveAll(entities);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		generateProfessions();
		generateItems();
		generateUsers();
	}
}
