package es.sia.css.test.domain.bet;

import es.sia.css.test.domain.valueobject.RoulettePosition;

public interface RouletteBet {
    ResolvedBet resolve(RoulettePosition position);
}
