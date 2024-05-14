package com.game.orangeblood.schedules;

import com.game.orangeblood.services.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegenSchedule {

    private final PartyService partyService;

    @Scheduled(fixedRate = 10000)
    public void executarTarefa() {
        partyService.moraleRegen();
        partyService.heroesAtributeRegen();
    }
}
