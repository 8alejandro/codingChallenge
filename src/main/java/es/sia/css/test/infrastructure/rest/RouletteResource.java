/*
 * Copyright (C) 2022 SIA
 * All rights reserved
 **/

package es.sia.css.test.infrastructure.rest;

import es.sia.css.test.application.placebet.PlaceColorRouletteBetCommand;
import es.sia.css.test.application.placebet.PlaceRouletteBetHandler;
import es.sia.css.test.application.placebet.PlaceSingleNumberRouletteBetCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roulette")
public class RouletteResource {

    private final PlaceRouletteBetHandler betHandler;

    public RouletteResource(PlaceRouletteBetHandler betHandler) {
        this.betHandler = betHandler;
    }

    @PostMapping("/bet-number")
    public void betNumber(@RequestBody BetNumberRequest request){
        PlaceSingleNumberRouletteBetCommand command = new PlaceSingleNumberRouletteBetCommand(
            request.getAmount(),
            request.getNumber()
        );
        betHandler.handle(command);
    }

    @PostMapping("/bet-color")
    public void betColor(@RequestBody BetColorRequest request){
        PlaceColorRouletteBetCommand command = new PlaceColorRouletteBetCommand(
            request.getAmount(),
            request.getColor()
        );
        betHandler.handle(command);
    }
}
