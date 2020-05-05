package com.games.hackandslash.service;

import java.util.ArrayList;
import java.util.List;

import com.games.hackandslash.model.Item;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.games.hackandslash.model.Profession;
import com.games.hackandslash.repository.ItemRepository;
import com.games.hackandslash.repository.ProfessionRepository;

@Service
public class GenerateDefaultData implements InitializingBean {
    @Autowired
    ProfessionRepository professionRepository;
    @Autowired
    ItemRepository itemRepository;

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

	@Override
	public void afterPropertiesSet() throws Exception {
		generateProfessions();
		generateItems();
	}
}
