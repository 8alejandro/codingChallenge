package es.sia.css.test.domain.roulette;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import es.sia.css.test.domain.bet.RouletteBet;
import es.sia.css.test.domain.bet.RouletteNumberBet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RouletteTest {

    NumberRandomizer numberRandomizer = mock(NumberRandomizer.class);

    @Test
    void of() {
        Roulette roulette = Roulette.of(numberRandomizer);
        Assertions.assertNotNull(roulette);
        Assertions.assertInstanceOf(Roulette.class, roulette);
    }

    @Test
    void placeBet() {
        RouletteBet betMock = mock(RouletteNumberBet.class);
        Roulette roulette = Roulette.of(numberRandomizer);
        roulette.placeBet(betMock);
        Assertions.assertEquals(betMock, roulette.getBet());
    }

    @Test
    void play() {
        Roulette roulette = Roulette.of(numberRandomizer);
        roulette.play();
        verify(numberRandomizer, times(1)).getNumber(anyInt());
    }
}