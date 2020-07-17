package br.com.deliverit.desafio.service;

import br.com.deliverit.desafio.entity.Accounts;
import br.com.deliverit.desafio.entity.Movement;
import br.com.deliverit.desafio.repository.MovementRepository;
import br.com.deliverit.desafio.service.treatment.DatasDiff;
import br.com.deliverit.desafio.service.treatment.Rules;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Data
public class MovementService {

    public final MovementRepository movementRepository;

    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public Page<Movement> accountsList(Pageable PageRequest) {
        return movementRepository.searchAll(PageRequest);
    }

    public String pay(Accounts accounts) {
        try {
            movementRepository.save((new Rules().calculateRules(accounts)));
            return "Save";
        } catch (Exception e) {
            return e.getMessage()+" "+e.getStackTrace();
        }
    }
}
