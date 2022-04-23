package es.sia.css.test.domain.bet;

import es.sia.css.test.domain.roulette.RouletteColor;
import es.sia.css.test.domain.user.User;
import es.sia.css.test.domain.valueobject.Cash;
import es.sia.css.test.domain.valueobject.RoulettePosition;

public class RouletteColorBet extends Bet implements RouletteBet {

    private final RouletteColor color;

    protected RouletteColorBet(Cash amount, User user, RouletteColor color) {
        super(amount, user);
        if(color == RouletteColor.GREEN)
            throw new IllegalColorException();
        this.color = color;
    }

    public static RouletteColorBet of(Cash amount, User user, RouletteColor color){
        return new RouletteColorBet(amount, user, color);
    }

    public RouletteColor getColor() {
        return color;
    }

    @Override
    public ResolvedBet resolve(RoulettePosition position) {
        return new ResolvedBet(
            this.getUser(),
            Cash.of(this.getAmount().value() * 2),
            this.color == position.getColor()
        );
    }

    public static final class IllegalColorException extends RuntimeException{

        public IllegalColorException() {
            super("You cannot bet on Green");
        }
    }
}
