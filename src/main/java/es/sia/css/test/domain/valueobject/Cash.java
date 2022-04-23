/*
 * Copyright (C) 2022 SIA
 * All rights reserved
 **/

package es.sia.css.test.domain.valueobject;

public final class Cash {

    private final Long value;

    private Cash(Long value) {
        if(value == null || value < 0) {
            throw new NotValidCashException();
        }
        this.value = value;
    }

    public static Cash of(Long value){
        return new Cash(value);
    }

    public Long value() {
        return value;
    }

    public boolean isGreaterOrEqualsTo(Cash amount) {
        return this.value >= amount.value();
    }

    public static final class NotValidCashException extends RuntimeException{

        public NotValidCashException() {
            super("Cash value not valid");
        }
    }
}
