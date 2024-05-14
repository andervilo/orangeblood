package com.game.orangeblood.dto;

import com.game.orangeblood.types.CombatResultType;
import com.game.orangeblood.types.CombatType;

public record CombatRegisterDto(int heroId, CombatType combatType, CombatResultType combatResultType) {
}
