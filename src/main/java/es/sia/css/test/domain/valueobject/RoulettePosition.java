package es.sia.css.test.domain.valueobject;

import es.sia.css.test.domain.roulette.RouletteColor;

public class RoulettePosition {
    private final Integer position;

    protected RoulettePosition(Integer position) {
        if(position < 0 || position > 36)
            throw new NotValidPositionException();
        this.position = position;
    }

    public static RoulettePosition of(Integer number){
        return new RoulettePosition(number);
    }

    public Integer getPosition() {
        return position;
    }

    public RouletteColor getColor(){
        if(position == 0)
            return RouletteColor.GREEN;
        if(position % 2 == 0)
            return RouletteColor.RED;
        return RouletteColor.BLACK;
    }

    public static final class NotValidPositionException extends RuntimeException{

        public NotValidPositionException() {
            super("Position must be a number in [0 .. 36]");
        }
    }

}
