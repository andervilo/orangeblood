package com.game.orangeblood.rest;

import com.game.orangeblood.dto.OrangeBloodHeroesPartyResponse;
import com.game.orangeblood.services.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/party")
@RequiredArgsConstructor
public class GetParty {

    private final PartyService partyService;

    @GetMapping
    public ResponseEntity<OrangeBloodHeroesPartyResponse> getParty() {
        return ResponseEntity.ok(partyService.getOrangeBloodHeroesParty());
    }
}
