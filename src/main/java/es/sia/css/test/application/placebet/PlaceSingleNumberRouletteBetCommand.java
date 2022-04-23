/*
 * Copyright (C) 2022 SIA
 * All rights reserved
 **/

package es.sia.css.test.application.placebet;

public class PlaceSingleNumberRouletteBetCommand {

    private final Long amount;
    private final Integer number;

    public PlaceSingleNumberRouletteBetCommand(Long amount, Integer number) {
        this.amount = amount;
        this.number = number;
    }

    public Long getAmount() {
        return amount;
    }

    public Integer getNumber() {
        return number;
    }
}
