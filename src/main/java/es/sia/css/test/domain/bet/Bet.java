package es.sia.css.test.domain.bet;

import es.sia.css.test.domain.user.User;
import es.sia.css.test.domain.valueobject.Cash;

public abstract class Bet {

    private final Cash amount;
    private final User user;

    protected Bet(Cash amount, User user) {
        if (!user.canAffordBet(amount)) { throw new UserCannotAffordBetException(); }
        user.withdrawCash(amount);
        this.amount = amount;
        this.user = user;
    }

    public Cash getAmount() {
        return amount;
    }

    public User getUser() {
        return user;
    }

    public static final class UserCannotAffordBetException extends RuntimeException {

        public UserCannotAffordBetException() {
            super("Cash value not valid");
        }
    }
}
