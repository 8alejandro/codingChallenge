/*
 * Copyright (C) 2022 SIA
 * All rights reserved
 **/

package es.sia.css.test.application.withdrawcash;

public class WithdrawCashCommand {

    private final Long amount;

    public WithdrawCashCommand(Long amount) {
        this.amount = amount;
    }

    public Long getAmount() {
        return amount;
    }
}
