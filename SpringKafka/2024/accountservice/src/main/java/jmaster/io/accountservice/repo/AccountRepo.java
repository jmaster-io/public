package jmaster.io.accountservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import jmaster.io.accountservice.model.AccountDTO;

public interface AccountRepo extends JpaRepository<AccountDTO, Integer> {

}
