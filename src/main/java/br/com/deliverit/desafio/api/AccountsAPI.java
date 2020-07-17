package br.com.deliverit.desafio.api;

import br.com.deliverit.desafio.entity.Accounts;
import br.com.deliverit.desafio.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("accounts")
public class AccountsAPI implements Serializable {

    @Autowired
    private final MovementService movementService;

    public AccountsAPI(MovementService movementService) {
        this.movementService = movementService;
    }

    @GetMapping()
    public ResponseEntity<?> ListAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int pageSize) {
        return new ResponseEntity<>(movementService.accountsList(PageRequest.of(page,pageSize)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Accounts account) {
        return new ResponseEntity<>(movementService.pay(account), HttpStatus.OK);
    }

}
