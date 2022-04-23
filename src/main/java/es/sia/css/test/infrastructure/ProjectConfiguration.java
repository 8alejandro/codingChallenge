/*
 * Copyright (C) 2022 SIA
 * All rights reserved
 **/

package es.sia.css.test.infrastructure;


import es.sia.css.test.application.placebet.PlaceRouletteBetHandler;
import es.sia.css.test.domain.roulette.NumberRandomizer;
import es.sia.css.test.domain.roulette.Roulette;
import es.sia.css.test.domain.user.User;
import es.sia.css.test.domain.valueobject.Cash;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

    @Bean
    public User createUser() {
        return User.of(Cash.of(100L));
    }

    @Bean
    public Roulette createRoulette(NumberRandomizer numberRandomizer) {
        return Roulette.of(numberRandomizer);
    }

    @Bean
    public PlaceRouletteBetHandler getAddBetHandler(User user, Roulette roulette) {
        return new PlaceRouletteBetHandler(user, roulette);
    }
}
