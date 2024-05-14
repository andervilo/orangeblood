package com.game.orangeblood.services;

import com.game.orangeblood.dto.CombatRegisterDto;
import com.game.orangeblood.dto.OrangeBloodHeroDto;
import com.game.orangeblood.dto.OrangeBloodHeroesPartyDto;
import com.game.orangeblood.dto.OrangeBloodHeroesPartyResponse;
import com.game.orangeblood.model.OrangeBloodHero;
import com.game.orangeblood.model.OrangeBloodHeroesParty;
import com.game.orangeblood.types.CombatResultType;
import com.game.orangeblood.types.CombatType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.function.Predicate;

import static org.mockito.Mockito.*;

class PartyServiceTest {

    PartyService partyService;

    @BeforeEach
    void setUp() {
        partyService = new PartyService();
    }

    @Test
    void testGetOrangeBloodHeroesParty() {
        OrangeBloodHeroesPartyResponse response = partyService.getOrangeBloodHeroesParty();
        Assertions.assertEquals(1000, response.party().morale());
    }

    @Test
    void testRegisterCombatLoseMelleHealth() {
        partyService.registerCombat(new CombatRegisterDto(0, CombatType.MELEE, CombatResultType.LOSE));
        OrangeBloodHeroesPartyResponse response = partyService.getOrangeBloodHeroesParty();
        Assertions.assertEquals(90, response.party().heroes().get(0).health());
    }

    @Test
    void testRegisterCombatWinMelleHealth() {
        partyService.registerCombat(new CombatRegisterDto(0, CombatType.MELEE, CombatResultType.WIN));
        OrangeBloodHeroesPartyResponse response = partyService.getOrangeBloodHeroesParty();
        Assertions.assertEquals(100, response.party().heroes().get(0).health());
    }

    @Test
    void testRegisterCombatLoseSpellMana() {
        partyService.registerCombat(new CombatRegisterDto(0, CombatType.SPELL, CombatResultType.LOSE));
        OrangeBloodHeroesPartyResponse response = partyService.getOrangeBloodHeroesParty();
        Assertions.assertEquals(90, response.party().heroes().get(0).mana());
    }

    @Test
    void testRegisterCombatWinSpellMana() {
        partyService.registerCombat(new CombatRegisterDto(0, CombatType.SPELL, CombatResultType.WIN));
        OrangeBloodHeroesPartyResponse response = partyService.getOrangeBloodHeroesParty();
        Assertions.assertEquals(100, response.party().heroes().get(0).mana());
    }
}
