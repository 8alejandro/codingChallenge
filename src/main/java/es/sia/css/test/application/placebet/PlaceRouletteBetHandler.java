/*
 * Copyright (C) 2022 SIA
 * All rights reserved
 **/

package es.sia.css.test.application.placebet;

import es.sia.css.test.domain.bet.ResolvedBet;
import es.sia.css.test.domain.bet.RouletteBet;
import es.sia.css.test.domain.bet.RouletteColorBet;
import es.sia.css.test.domain.bet.RouletteNumberBet;
import es.sia.css.test.domain.roulette.Roulette;
import es.sia.css.test.domain.user.User;
import es.sia.css.test.domain.valueobject.Cash;
import es.sia.css.test.domain.valueobject.RoulettePosition;
import java.util.Optional;

public class PlaceRouletteBetHandler {

    private final User user;
    private final Roulette roulette;

    public PlaceRouletteBetHandler(User user, Roulette roulette) {
        this.user = user;
        this.roulette = roulette;
    }

    public void handle(PlaceSingleNumberRouletteBetCommand command) {
        if(user.getCash().value() > command.getAmount()) {
            RouletteBet bet = RouletteNumberBet.of(Cash.of(command.getAmount()), user,
                RoulettePosition.of(command.getNumber()));
            placeAndResolveBet(bet);
        } else {
            throw new User.NotEnoughCashException(user.getCash());
        }
    }

    public void handle(PlaceColorRouletteBetCommand command) {
        if(user.getCash().value() > command.getAmount()) {
            RouletteBet bet = RouletteColorBet.of(Cash.of(command.getAmount()), user, command.getColor());
            placeAndResolveBet(bet);
        } else {
            throw new User.NotEnoughCashException(user.getCash());
        }
    }

    private void placeAndResolveBet(RouletteBet bet) {
        roulette.placeBet(bet);
        Optional<ResolvedBet> betResult = roulette.play();
        betResult.ifPresent(ResolvedBet::resolveBet);
    }
}
