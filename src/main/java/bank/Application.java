package bank;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.AccountService;
import bank.service.DTO.AccountDTO.*;
import bank.service.DTO.AccountEntryDTO.AccountEntryDTO;
import bank.service.DTO.CustomerDTO.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;


@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		System.out.println();

		//use account 1;
		accountService.deposit(1263862, 240);
		accountService.deposit(1263862, 529);
		accountService.withdrawEuros(1263862, 230);

		//use account 2;
		accountService.deposit(4253892, 12450);
		accountService.depositEuros(4253892, 200);
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");

		// show balances
		Collection<AccountDTO> accountlist = accountService.getAllAccountDTOs();
		CustomerDTO customer = null;
		//System.out.println(accountService.getAllAccountDTOs());
		//System.out.println(accountService.getAllAccounts());
		for (AccountDTO account : accountlist) {
			customer = account.getCustomerDTO();
			System.out.println("Statement for Account: " + account.getAccountNumberDTO());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
					+ "-Description------------------"
					+ "-Amount-------------");
			for (AccountEntryDTO entry : account.getEntryListDTO()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}

	}
}


