/*
 * Copyright (C) 2022 SIA
 * All rights reserved
 **/

package es.sia.css.test.domain.user;

import es.sia.css.test.domain.bet.ResolvedBet;
import es.sia.css.test.domain.valueobject.Cash;

public final class User {

    private Cash cash;

    private User(Cash cash) {
        this.cash = cash;
    }

    public static User of(Cash initialCash) {
        return new User(initialCash);
    }

    public Cash getCash() {
        return cash;
    }


    public void depositCash(Cash amount) {
        this.cash = Cash.of(this.cash.value() + amount.value());
    }

    public boolean canAffordBet(Cash betAmount) {
        return cash.isGreaterOrEqualsTo(betAmount);
    }

    public void withdrawCash(Cash amount) {
        if (!cash.isGreaterOrEqualsTo(amount)) { throw new NotEnoughCashException(cash); }
        this.cash = Cash.of(this.cash.value() - amount.value());
    }

    public void resolveBet(ResolvedBet result) {
        if(result.getWinningBet()){
            cash = Cash.of(cash.value() + result.getAmount().value());
        } else {
            cash = Cash.of(cash.value() - result.getAmount().value());
        }
    }

    public static final class NotEnoughCashException extends RuntimeException {

        public NotEnoughCashException(Cash currentCash) {
            super(String.format("Not enough cash. Current cash: %d", currentCash.value()));
        }
    }
}
