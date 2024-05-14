package com.game.orangeblood.dto;

import lombok.Builder;

@Builder
public record OrangeBloodHeroDto(
        int id,
        int health,
        int mana
) {
}
