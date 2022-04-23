/*
 * Copyright (C) 2022 SIA
 * All rights reserved
 **/

package es.sia.css.test.application.depositcash;

public class DepositCashCommand {

    private final Long amount;

    public DepositCashCommand(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }
}
