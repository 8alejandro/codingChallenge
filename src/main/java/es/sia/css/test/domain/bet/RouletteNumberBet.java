package es.sia.css.test.domain.bet;

import es.sia.css.test.domain.user.User;
import es.sia.css.test.domain.valueobject.Cash;
import es.sia.css.test.domain.valueobject.RoulettePosition;

public class RouletteNumberBet extends Bet implements RouletteBet {

    private final RoulettePosition number;

    protected RouletteNumberBet(Cash amount, User user, RoulettePosition number) {
        super(amount, user);
        this.number = number;
    }

    public static RouletteNumberBet of(Cash amount, User user, RoulettePosition number) {
        return new RouletteNumberBet(amount, user, number);
    }

    public RoulettePosition getNumber() {
        return number;
    }

    @Override
    public ResolvedBet resolve(RoulettePosition position) {
        return new ResolvedBet(
            this.getUser(),
            Cash.of(this.getAmount().value() * 35),
            position.getPosition().equals(this.number.getPosition())
        );
    }
}
