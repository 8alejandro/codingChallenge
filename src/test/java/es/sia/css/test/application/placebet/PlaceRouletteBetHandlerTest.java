package es.sia.css.test.application.placebet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import es.sia.css.test.domain.roulette.NumberRandomizer;
import es.sia.css.test.domain.roulette.Roulette;
import es.sia.css.test.domain.roulette.RouletteColor;
import es.sia.css.test.domain.user.User;
import es.sia.css.test.domain.user.User.NotEnoughCashException;
import es.sia.css.test.domain.valueobject.Cash;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlaceRouletteBetHandlerTest {
    NumberRandomizer numberRandomizerMock = mock(NumberRandomizer.class);

    @Test
    void winningColorBet() {
        User user = User.of(Cash.of(100L));

        PlaceRouletteBetHandler subject = new PlaceRouletteBetHandler(
            user,
            Roulette.of(numberRandomizerMock)
        );

        when(numberRandomizerMock.getNumber(37)).thenReturn(6);

        PlaceColorRouletteBetCommand command = new PlaceColorRouletteBetCommand(1L, RouletteColor.RED);
        subject.handle(command);

        Assertions.assertEquals(101L, user.getCash().value());
    }

    @Test
    void notEnoughCashExceptionWhenLosingColorBet() {
        User user = User.of(Cash.of(100L));

        PlaceRouletteBetHandler subject = new PlaceRouletteBetHandler(
            user,
            Roulette.of(numberRandomizerMock)
        );

        when(numberRandomizerMock.getNumber(37)).thenReturn(7);

        PlaceColorRouletteBetCommand command = new PlaceColorRouletteBetCommand(50L, RouletteColor.RED);

        Assertions.assertThrows(NotEnoughCashException.class, () -> subject.handle(command));
    }

    @Test
    void losingColorBet() {
        User user = User.of(Cash.of(100L));

        PlaceRouletteBetHandler subject = new PlaceRouletteBetHandler(
            user,
            Roulette.of(numberRandomizerMock)
        );

        when(numberRandomizerMock.getNumber(37)).thenReturn(7);

        PlaceColorRouletteBetCommand command = new PlaceColorRouletteBetCommand(50L, RouletteColor.RED);

        // TODO añadir aserciones
    }

    @Test
    void winningNumericBet() {
        // TODO
    }

    @Test
    void losingNumericBet() {
        // TODO
    }

}