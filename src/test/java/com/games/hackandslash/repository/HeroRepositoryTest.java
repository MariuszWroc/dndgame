package com.games.hackandslash.repository;

import com.games.hackandslash.common.Category;
import com.games.hackandslash.model.Hero;
import com.games.hackandslash.model.Item;
import com.games.hackandslash.model.Profession;
import com.games.hackandslash.util.DefaultHero;
import com.games.hackandslash.util.DefaultProfession;
import com.games.hackandslash.util.StreamHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class HeroRepositoryTest {
    private Hero heroMock;
    private Item potion;
    private Item attackSpell;
    private Item defendSpell;
    private Item healthSpell;
    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private ProfessionRepository professionRepository;
    @Autowired
    private ItemRepository itemRepository;

    @BeforeAll
    public static void setUpBeforeClass() {

    }

    @BeforeEach
    public void injectedComponentsAreNotNull(){
        List<Item> items = new ArrayList<>();
        potion = Item.builder().id(1L).name("potion").health(5).category(Category.POTION).build();
        attackSpell = Item.builder().id(2L).name("magic bullet").attack(6).category(Category.SPELL_ATTACK).build();
        defendSpell = Item.builder().id(3L).name("shield").defend(3).category(Category.SPELL_DEFEND).build();
        healthSpell = Item.builder().id(4L).name("heal").health(8).category(Category.SPELL_HEALTH).build();
        items.add(potion);
        items.add(attackSpell);
        items.add(defendSpell);
        items.add(healthSpell);

        assertThat(itemRepository, is(notNullValue()));
        Iterable<Item> itemsFromRepository = itemRepository.saveAll(items);
        assertThat(itemsFromRepository, is(notNullValue()));

        assertThat(professionRepository, is(notNullValue()));
        Profession profession = professionRepository.save(DefaultProfession.PALADIN.getProfession());
        assertThat(profession, is(notNullValue()));

        heroMock = DefaultHero.LADY_ARIBETH.getHero(profession, new ArrayList<>());
        assertThat(heroRepository, is(notNullValue()));
        assertThat(heroRepository.save(heroMock), is(notNullValue()));
    }

    @Test
    public void testUpdateHealthAfterDamage(){
        Hero hero = heroRepository.findAll().iterator().next();
        hero.updateHealth(10);
        Integer currentHP = hero.getCurrentHP();
        Integer hpAfterChange = heroMock.getCurrentHP();
        assertEquals(currentHP, hpAfterChange);
    }

    @Test
    public void testCountAttack() {
        heroMock.countAttack();
    }

    @Test
    public void testCountDefend() {
        heroMock.countDefend();
    }

    @Test
    public void testUsePotion() {
        heroMock.useItem(potion);
        heroRepository.findAll().iterator().next();
        Hero hero = heroRepository.findAll().iterator().next();
        int currentHP = hero.getCurrentHP();
        int hpAfterChange = heroMock.getCurrentHP();
        assertEquals(currentHP, hpAfterChange);
    }

    @Test
    public void testUseAttackSpell() {
        heroMock.useItem(attackSpell);
        Hero hero = heroRepository.findAll().iterator().next();
        int attackPoints = hero.getAttackPoints();
        int attackPointsAfterChange = heroMock.getAttackPoints();
        assertEquals(attackPoints, attackPointsAfterChange);
    }

    @Test
    public void testUseDefendSpell() {
        heroMock.useItem(defendSpell);
        Hero hero = heroRepository.findAll().iterator().next();
        int currentAC = hero.getFinalAC();
        int acAfterChange = heroMock.getFinalAC();
        assertEquals(currentAC, acAfterChange);
    }

    @Test
    public void testUseHealthSpell() {
        heroMock.useItem(healthSpell);
        Hero hero = heroRepository.findAll().iterator().next();
        int currentHP = hero.getCurrentHP();
        int hpAfterChange = heroMock.getCurrentHP();
        assertEquals(currentHP, hpAfterChange);
    }
}

