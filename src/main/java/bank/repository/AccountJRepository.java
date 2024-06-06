package bank.repository;

import bank.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AccountJRepository extends JpaRepository<Account, Long> {
    Account findByAccountNumber(long accountNumber);
}
