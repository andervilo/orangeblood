package com.game.orangeblood.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrangeBloodHeroTest {
    OrangeBloodHero orangeBloodHero;

    @BeforeEach
    void setUp() {
        orangeBloodHero = new OrangeBloodHero();
    }

    @Test
    void testCreateHero() {
        Assertions.assertEquals(100, orangeBloodHero.getHealth());
        Assertions.assertEquals(100, orangeBloodHero.getMana());
    }

    @Test
    void testIncreaseHealthWhenHealthEquals100() {
        orangeBloodHero.increaseHealth(10);
        Assertions.assertEquals(100, orangeBloodHero.getHealth());
    }

    @Test
    void testIncreaseManaWhenManaEquals100() {
        orangeBloodHero.increaseMana(10);
        Assertions.assertEquals(100, orangeBloodHero.getMana());
    }

    @Test
    void testIncreaseHealth() {
        orangeBloodHero.decreaseHealth(20);
        orangeBloodHero.increaseHealth(10);
        Assertions.assertEquals(90, orangeBloodHero.getHealth());
    }

    @Test
    void testIncreaseMana() {
        orangeBloodHero.decreaseMana(20);
        orangeBloodHero.increaseMana(10);
        Assertions.assertEquals(90, orangeBloodHero.getMana());
    }

    @Test
    void testDecreaseHealthWhenHealthEquals0() {
        orangeBloodHero.decreaseHealth(100);
        orangeBloodHero.decreaseHealth(30);
        Assertions.assertEquals(0, orangeBloodHero.getHealth());
    }

    @Test
    void testDecreaseManaWhenHManaEquals0() {
        orangeBloodHero.decreaseMana(100);
        orangeBloodHero.decreaseMana(35);
        Assertions.assertEquals(0, orangeBloodHero.getMana());
    }

    @Test
    void testDecreaseHealth() {
        orangeBloodHero.decreaseHealth(30);
        Assertions.assertEquals(70, orangeBloodHero.getHealth());
    }

    @Test
    void testDecreaseMana() {
        orangeBloodHero.decreaseMana(35);
        Assertions.assertEquals(65, orangeBloodHero.getMana());
    }

    @Test
    void testRegenMana() {
        orangeBloodHero.decreaseMana(35);
        orangeBloodHero.manaRegen();
        Assertions.assertEquals(67, orangeBloodHero.getMana());
    }

    @Test
    void testRegenHealth() {
        orangeBloodHero.decreaseHealth(30);
        orangeBloodHero.healthRegen();
        Assertions.assertEquals(72, orangeBloodHero.getHealth());
    }

}
