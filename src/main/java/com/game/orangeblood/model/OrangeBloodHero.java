package com.game.orangeblood.model;

import lombok.*;

@Getter
@EqualsAndHashCode(exclude = {"health", "mana"})
@ToString
public class OrangeBloodHero {
    @Setter
    private int id;
    private int health;
    private int mana;

    public OrangeBloodHero() {
        this.health = 100;
        this.mana = 100;
    }

    public void increaseHealth(int health) {
        this.health += health;
        if (this.health > 100) this.health = 100;
    }

    public void increaseMana(int mana) {
        this.mana += mana;
        if (this.mana > 100) this.mana = 100;
    }

    public void decreaseHealth(int health) {
        this.health -= health;
        if (this.health < 0)  this.health = 0;
    }

    public void decreaseMana(int mana) {
        this.mana -= mana;
        if (this.mana < 0) this.mana = 0;
    }

    public void manaRegen() {
        this.increaseMana(2);
    }

    public void healthRegen() {
        this.increaseHealth(2);
    }

    public void regen() {
        this.healthRegen();
        this.manaRegen();
    }
}
