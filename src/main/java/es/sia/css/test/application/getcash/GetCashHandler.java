package es.sia.css.test.application.getcash;

import es.sia.css.test.domain.user.User;
import es.sia.css.test.domain.valueobject.Cash;
import org.springframework.stereotype.Service;

@Service
public class GetCashHandler {

    private final User user;

    public GetCashHandler(User user) {
        this.user = user;
    }

    public Cash handle(GetCashQuery query) {
        return user.getCash();
    }
}
