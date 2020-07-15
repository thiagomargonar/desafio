package br.com.deliverit.desafio.repository;

import br.com.deliverit.desafio.entity.Accounts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {

    @Query(nativeQuery = true, value="select c.* from Accounts c", countQuery = "select c.* from Accounts c")
    Page<Accounts> searchAll(Pageable pageable);

}
