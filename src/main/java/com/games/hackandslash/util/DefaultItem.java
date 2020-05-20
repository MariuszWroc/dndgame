package com.games.hackandslash.util;

import com.games.hackandslash.model.Item;

public enum DefaultItem {
    SWORD{
        @Override
        public Item getItem() {
            return Item.builder().name("Sword").build();
        }
    }, POTION {
        @Override
        public Item getItem() {
            return Item.builder().name("Potion").build();
        }
    }, BOW {
        @Override
        public Item getItem() {
            return Item.builder().name("Bow").build();
        }
    }, FULL_PLATE_ARMOR {
        @Override
        public Item getItem() {
            return Item.builder().name("Full plate armor").build();
        }
    }, PLATE_ARMOR {
        @Override
        public Item getItem() {
            return Item.builder().name("Plate armor").build();
        }
    }, HAUBERK {
        @Override
        public Item getItem() {
            return Item.builder().name("Hauberk").build();
        }
    }, CLOAK {
        @Override
        public Item getItem() {
            return Item.builder().name("Cloak").build();
        }
    }, MAGIC_BULLET {
        @Override
        public Item getItem() {
            return Item.builder().name("Magic bullet").build();
        }
    }, HEALING {
        @Override
        public Item getItem() {
            return Item.builder().name("Healing").build();
        }
    };

    public abstract Item getItem();
}
