/*
 * Copyright (C) 2022 SIA
 * All rights reserved
 **/

package es.sia.css.test.application.withdrawcash;

import es.sia.css.test.domain.valueobject.Cash;
import es.sia.css.test.domain.user.User;

public class WithdrawCashHandler {

    private final User user;

    public WithdrawCashHandler(User user) {
        this.user = user;
    }

    public void handle(WithdrawCashCommand command){
        Cash amount = Cash.of(command.getAmount());

        user.withdrawCash(amount);
    }
}
