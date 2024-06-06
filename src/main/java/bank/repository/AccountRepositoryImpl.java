package bank.repository;

import bank.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class AccountRepositoryImpl implements AccountJpaRepository  {

    @Autowired
    private AccountJRepository accountJRepository;

	public void saveAccount(Account account) {
		// System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
		accountJRepository.save(account);
	}

	public void updateAccount(Account account) {
		// System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
        accountJRepository.save(account);

	}

	public Account loadAccount(long accountNumber) {
		return accountJRepository.findByAccountNumber(accountNumber);
	}

	public Collection<Account> getAccounts() {
		return accountJRepository.findAll();
	}

}
