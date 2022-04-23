/*
 * Copyright (C) 2022 SIA
 * All rights reserved
 **/

package es.sia.css.test.infrastructure.rest;

public class BetNumberRequest {

    private Long amount;
    private Integer number;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
