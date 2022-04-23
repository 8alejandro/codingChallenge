package es.sia.css.test.infrastructure.rest;

import es.sia.css.test.domain.roulette.RouletteColor;

public class BetColorRequest {
    private Long amount;
    private RouletteColor color;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public RouletteColor getColor() {
        return color;
    }

    public void setColor(RouletteColor color) {
        this.color = color;
    }
}
