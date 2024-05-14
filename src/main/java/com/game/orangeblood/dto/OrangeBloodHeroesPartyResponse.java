package com.game.orangeblood.dto;

import lombok.Builder;

@Builder
public record OrangeBloodHeroesPartyResponse(
        OrangeBloodHeroesPartyDto party,
        long timestamp
) {
}
