package com.game.orangeblood.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrangeBloodHeroesParty {

    private List<OrangeBloodHero> heroes;
    private int morale;

    public void addHero(OrangeBloodHero hero) {
        if (heroes.size() == 5) throw new IllegalStateException("Party is full");
        if (heroes.isEmpty()) hero.setId(0);
        else hero.setId(heroes.size()+1);
        heroes.add(hero);
    }

    public void increaseMorale(int morale) {
        this.morale += morale;
        if (this.morale > 1000) this.morale = 1000;

    }

    public void decreaseMorale(int morale) {
        this.morale -= morale;
        if (this.morale < 0) this.morale = 0;
    }

    public void moraleRegen() {
        this.increaseMorale(20);
    }

}
