package accountservice.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import accountservice.accountservice.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
