package br.com.deliverit.desafio.repository;

import br.com.deliverit.desafio.entity.Accounts;
import br.com.deliverit.desafio.entity.Movement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends CrudRepository<Movement, Long> {

    @Query(nativeQuery = true, value="select c.* from movement c", countQuery = "select c.* from movement c")
    Page<Movement> searchAll(Pageable pageable);

}
