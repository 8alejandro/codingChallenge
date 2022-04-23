package es.sia.css.test.domain.bet;

import es.sia.css.test.domain.user.User;
import es.sia.css.test.domain.valueobject.Cash;

public class ResolvedBet {
    private final User user;
    private final Cash amount;
    private final Boolean winningBet;

    public ResolvedBet(User user, Cash amount, Boolean winningBet) {
        this.user = user;
        this.amount = amount;
        this.winningBet = winningBet;
    }

    public User getUser() {
        return user;
    }

    public Cash getAmount() {
        return amount;
    }

    public Boolean getWinningBet() {
        return winningBet;
    }

    public void resolveBet() {
        user.resolveBet(this);
    }
}
