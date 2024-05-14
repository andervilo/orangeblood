package com.game.orangeblood.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Set;

import static org.mockito.Mockito.*;

class OrangeBloodHeroesPartyTest {

    OrangeBloodHeroesParty orangeBloodHeroesParty;

    @BeforeEach
    void setUp() {
        orangeBloodHeroesParty = OrangeBloodHeroesParty.builder().heroes(new ArrayList<>()).morale(1000).build();
    }

    @Test
    void testAddHero() {
        orangeBloodHeroesParty.addHero(new OrangeBloodHero());
        Assertions.assertEquals(1, orangeBloodHeroesParty.getHeroes().size());
        Assertions.assertEquals(0, orangeBloodHeroesParty.getHeroes().iterator().next().getId());
    }

    @Test
    void testAddHeroThrowsException() {
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> {
            for (int i = 0; i < 6; i++) {
                orangeBloodHeroesParty.addHero(new OrangeBloodHero());
            }
        });
    }

    @Test
    void testAddHeroFull() {
        orangeBloodHeroesParty.addHero(new OrangeBloodHero());
        orangeBloodHeroesParty.addHero(new OrangeBloodHero());
        orangeBloodHeroesParty.addHero(new OrangeBloodHero());
        Assertions.assertEquals(3, orangeBloodHeroesParty.getHeroes().size());
        Assertions.assertEquals(0, orangeBloodHeroesParty.getHeroes().iterator().next().getId());
    }

    @Test
    void testIncreseMorale() {
        orangeBloodHeroesParty.decreaseMorale(30);
        orangeBloodHeroesParty.increaseMorale(10);
        Assertions.assertEquals(980, orangeBloodHeroesParty.getMorale());
    }

    @Test
    void testIncreseMoraleWhenMoraleEquals1000() {
        orangeBloodHeroesParty.increaseMorale(10);
        Assertions.assertEquals(1000, orangeBloodHeroesParty.getMorale());
    }

    @Test
    void testDcreseMOrale() {
        orangeBloodHeroesParty.decreaseMorale(30);
        Assertions.assertEquals(970, orangeBloodHeroesParty.getMorale());
    }

}
