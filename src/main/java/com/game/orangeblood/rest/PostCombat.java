package com.game.orangeblood.rest;

import com.game.orangeblood.dto.CombatRegisterDto;
import com.game.orangeblood.services.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/combat")
@RequiredArgsConstructor
public class PostCombat {

    private final PartyService partyService;

    @PostMapping
    public ResponseEntity<Void> postCombat(@RequestBody CombatRegisterDto combatRegisterDto) {
        partyService.registerCombat(combatRegisterDto);
        return ResponseEntity.accepted().build();
    }
}
