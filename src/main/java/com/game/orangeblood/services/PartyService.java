package com.game.orangeblood.services;

import com.game.orangeblood.dto.CombatRegisterDto;
import com.game.orangeblood.dto.OrangeBloodHeroDto;
import com.game.orangeblood.dto.OrangeBloodHeroesPartyDto;
import com.game.orangeblood.dto.OrangeBloodHeroesPartyResponse;
import com.game.orangeblood.exceptions.BadRequestException;
import com.game.orangeblood.exceptions.NotFoundException;
import com.game.orangeblood.model.OrangeBloodHero;
import com.game.orangeblood.model.OrangeBloodHeroesParty;
import com.game.orangeblood.types.CombatResultType;
import com.game.orangeblood.types.CombatType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PartyService {

    private final OrangeBloodHeroesParty orangeBloodHeroesParty;


    public PartyService() {
        this.orangeBloodHeroesParty = OrangeBloodHeroesParty.builder().heroes(new ArrayList<>()).morale(1000).build();
        this.addHeroesToParty();
    }

    private void addHeroesToParty() {
        for (int i = 0; i < 5; i++) {
            orangeBloodHeroesParty.addHero(new OrangeBloodHero());
        }
    }

    public void moraleRegen() {
        this.orangeBloodHeroesParty.moraleRegen();
    }

    public void heroesAtributeRegen() {
        this.orangeBloodHeroesParty.getHeroes().forEach(OrangeBloodHero::regen);
    }

    public OrangeBloodHeroesPartyResponse getOrangeBloodHeroesParty() {
        return OrangeBloodHeroesPartyResponse.builder()
                .party(OrangeBloodHeroesPartyDto.builder()
                        .heroes(orangeBloodHeroesParty.getHeroes().stream().map(hero -> OrangeBloodHeroDto.builder()
                                .id(hero.getId())
                                .health(hero.getHealth())
                                .mana(hero.getMana())
                                .build()).collect(Collectors.toList()))
                        .morale(orangeBloodHeroesParty.getMorale())
                        .build())
                .timestamp(System.currentTimeMillis())
                .build();
    }

    public void registerCombat(CombatRegisterDto combat) {
        log.info("Combat registere call: {}", combat.toString());
        this.orangeBloodHeroesParty.getHeroes().forEach(hero -> {
            if (!isIdHeroValid.test(combat)) throw new BadRequestException("");
            if (!isHeroReadyToCombat.test(hero)) throw new NotFoundException("Hero is not ready to combat");
            if (hero.getId() == combat.heroId()) {
                processCombat(combat, hero);
            }
        });
    }

    private void processCombat(CombatRegisterDto combat, OrangeBloodHero hero) {
        processMeleeCombat(combat, hero);
        processSpellCombat(combat, hero);
        processMorale(combat, hero);
    }

    private void processSpellCombat(CombatRegisterDto combat, OrangeBloodHero hero) {
        if (isSpellCombatAndWin.test(combat)) hero.increaseMana(1);
        if (isSpellCombatAndLose.test(combat)) hero.increaseMana(-10);
    }

    private void processMeleeCombat(CombatRegisterDto combat, OrangeBloodHero hero) {
        if (isMelleCombatAndWin.test(combat)) hero.increaseHealth(1);
        if (isMelleCombatAndLose.test(combat)) hero.increaseHealth(-10);
    }

    private void processMorale(CombatRegisterDto combat, OrangeBloodHero hero) {
        if (isSpellCombatAndWin.or(isMelleCombatAndWin).test(combat)) this.orangeBloodHeroesParty.increaseMorale(1);
        if (isSpellCombatAndLose.or(isMelleCombatAndLose).test(combat)) this.orangeBloodHeroesParty.decreaseMorale(10);
    }

    private final Predicate<CombatRegisterDto> isMelleCombatAndWin = combat -> combat.combatType().equals(CombatType.MELEE)
            && combat.combatResultType().equals(CombatResultType.WIN);

    private final Predicate<CombatRegisterDto> isMelleCombatAndLose = combat -> combat.combatType().equals(CombatType.MELEE)
            && combat.combatResultType().equals(CombatResultType.LOSE);

    private final Predicate<CombatRegisterDto> isSpellCombatAndWin = combat -> combat.combatType().equals(CombatType.SPELL)
            && combat.combatResultType().equals(CombatResultType.WIN);

    private final Predicate<CombatRegisterDto> isSpellCombatAndLose = combat -> combat.combatType().equals(CombatType.SPELL)
            && combat.combatResultType().equals(CombatResultType.LOSE);

    private final Predicate<CombatRegisterDto> isIdHeroValid = combat -> combat.heroId() >= 0 && combat.heroId() < 5;

    private final Predicate<OrangeBloodHero> isHeroReadyToCombat = hero -> hero.getMana() > 0 && hero.getHealth() > 0;
}
