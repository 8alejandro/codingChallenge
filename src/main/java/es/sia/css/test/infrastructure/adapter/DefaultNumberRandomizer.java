package es.sia.css.test.infrastructure.adapter;

import es.sia.css.test.domain.roulette.NumberRandomizer;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class DefaultNumberRandomizer implements NumberRandomizer {

    @Override
    public Integer getNumber(int maxNumberExclusive) {
        Random rand = new Random();
        return rand.nextInt(maxNumberExclusive);
    }
}
