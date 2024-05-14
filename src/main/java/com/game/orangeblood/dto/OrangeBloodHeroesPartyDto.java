package com.game.orangeblood.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record OrangeBloodHeroesPartyDto (
        List<OrangeBloodHeroDto> heroes,
        int morale
) {
}
