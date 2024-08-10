package jmaster.io.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jmaster.io.accountservice.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
