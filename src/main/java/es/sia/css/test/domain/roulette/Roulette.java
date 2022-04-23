/*
 * Copyright (C) 2022 SIA
 * All rights reserved
 **/

package es.sia.css.test.domain.roulette;

import es.sia.css.test.domain.bet.ResolvedBet;
import es.sia.css.test.domain.bet.RouletteBet;
import es.sia.css.test.domain.valueobject.RoulettePosition;
import java.util.Optional;

public final class Roulette {

    private RouletteBet bet;
    private final NumberRandomizer numberRandomizer;

    private Roulette(NumberRandomizer numberRandomizer) {
        this.numberRandomizer = numberRandomizer;
    }

    public static Roulette of(NumberRandomizer numberRandomizer) {
        return new Roulette(numberRandomizer);
    }

    public void placeBet(RouletteBet bet) {
        this.bet = bet;
    }

    public Optional<ResolvedBet> play() {
        RoulettePosition winningPosition = getRandomPosition();
        return Optional.of(bet.resolve(winningPosition));
    }

    private RoulettePosition getRandomPosition() {
        return RoulettePosition.of(numberRandomizer.getNumber(37));
    }

    public RouletteBet getBet() {
        return bet;
    }
}
