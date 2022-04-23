/*
 * Copyright (C) 2022 SIA
 * All rights reserved
 **/

package es.sia.css.test.application.placebet;

import es.sia.css.test.domain.roulette.RouletteColor;

public class PlaceColorRouletteBetCommand {

    private final Long amount;
    private final RouletteColor color;

    public PlaceColorRouletteBetCommand(Long amount, RouletteColor color) {
        this.amount = amount;
        this.color = color;
    }

    public Long getAmount() {
        return amount;
    }

    public RouletteColor getColor() {
        return color;
    }
}
