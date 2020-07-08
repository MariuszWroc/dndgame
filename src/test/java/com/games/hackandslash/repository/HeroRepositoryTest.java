package com.games.hackandslash.repository;

import com.games.hackandslash.model.Hero;
import com.games.hackandslash.model.Profession;
import com.games.hackandslash.util.DefaultHero;
import com.games.hackandslash.util.DefaultProfession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class HeroRepositoryTest {
    private Hero hero;
    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private ProfessionRepository professionRepository;

    @BeforeAll
    public static void setUpBeforeClass() {

    }

    @BeforeEach
    public void injectedComponentsAreNotNull(){
        Profession profession = professionRepository.save(DefaultProfession.PALADIN.getProfession());
        hero = DefaultHero.LADY_ARIBETH.getHero(profession, new ArrayList<>());
        assertThat(heroRepository, is(notNullValue()));
        assertThat(heroRepository.save(hero), is(notNullValue()));
    }

    @Test
    public void testUpdateHealthAfterDamage(){
        Hero hero = heroRepository.findById(1L).get();
        hero.updateHealth(10);
        Integer currentHP = hero.getCurrentHP();
        Hero heroWithNewHP = heroRepository.findById(1L).get();
        Integer hpAfterChange = heroWithNewHP.getCurrentHP();
        assertEquals(currentHP, hpAfterChange);
    }
}
