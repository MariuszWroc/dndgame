package com.games.hackandslash.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @BeforeEach
    public void injectedComponentsAreNotNull(){
        assertThat(itemRepository, is(notNullValue()));
    }

    @Test
    public void findByName() {

    }
}
