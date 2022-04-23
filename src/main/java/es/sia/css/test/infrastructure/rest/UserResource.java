package es.sia.css.test.infrastructure.rest;

import es.sia.css.test.application.depositcash.DepositCashCommand;
import es.sia.css.test.application.depositcash.DepositCashHandler;
import es.sia.css.test.application.getcash.GetCashHandler;
import es.sia.css.test.application.getcash.GetCashQuery;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    private final GetCashHandler getCashHandler;
    private final DepositCashHandler depositCashHandler;

    public UserResource(GetCashHandler getCashHandler, DepositCashHandler depositCashHandler) {
        this.getCashHandler = getCashHandler;
        this.depositCashHandler = depositCashHandler;
    }

    @GetMapping("/cash")
    public Long getCash() {
        GetCashQuery getCashQuery = new GetCashQuery();
        return getCashHandler.handle(getCashQuery).value();
    }

    @PostMapping("/cash")
    public void depositCash(@RequestBody DepositCashRequest depositCashRequest) {
        DepositCashCommand depositCashCommand = new DepositCashCommand(depositCashRequest.getAmount());
        depositCashHandler.handle(depositCashCommand);
    }
}
