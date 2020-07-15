package br.com.deliverit.desafio.api;

import br.com.deliverit.desafio.entity.Accounts;
import br.com.deliverit.desafio.service.AccountsService;
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
    private final AccountsService service;

    public AccountsAPI(AccountsService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<?> ListAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int pageSize) {
        return new ResponseEntity<>(service.accountsList(PageRequest.of(page,pageSize)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Accounts account) {
        return new ResponseEntity<>(service.accountsRepository.save(account), HttpStatus.OK);
    }

    @PutMapping(path = "/pay")
    public ResponseEntity<?> pay(@RequestBody Accounts account) {
        return new ResponseEntity<>(service.pay(account), HttpStatus.OK);
    }
}
