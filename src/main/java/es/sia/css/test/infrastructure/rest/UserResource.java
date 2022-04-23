package es.sia.css.test.infrastructure.rest;

import es.sia.css.test.application.getcash.GetCashHandler;
import es.sia.css.test.application.getcash.GetCashQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    private final GetCashHandler getCashHandler;

    public UserResource(GetCashHandler getCashHandler) {
        this.getCashHandler = getCashHandler;
    }

    @GetMapping("/cash")
    public Long getCash() {
        GetCashQuery getCashQuery = new GetCashQuery();
        return getCashHandler.handle(getCashQuery).value();
    }
}
