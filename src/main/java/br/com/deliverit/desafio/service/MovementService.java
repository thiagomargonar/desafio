package br.com.deliverit.desafio.service;

import br.com.deliverit.desafio.entity.Accounts;
import br.com.deliverit.desafio.repository.AccountsRepository;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Data
public class AccountsService {

    public final AccountsRepository accountsRepository;

    public AccountsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public Page<Accounts> accountsList(Pageable PageRequest){
        return accountsRepository.searchAll(PageRequest);
    }

    public Accounts pay(Accounts account) {

        return accountsRepository.save(account);
    }
}
