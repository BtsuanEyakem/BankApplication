package bank.service.DTO.AccountDTO;

import bank.domain.Account;
import bank.service.DTO.AccountEntryDTO.*;
import bank.service.DTO.CustomerDTO.*;

public class AccountAdaptor {

    public static AccountDTO AccountToAccountDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO(account.getAccountNumber());
        accountDTO.setCustomerDTO(CustomerAdaptor.custotomerDTOfromCustomer(account.getCustomer()));
        accountDTO.setEntryListDTO(AccountEntryAdaptor.AccountEntryDTOfromAccountEntryList(account.getEntryList()));
        return accountDTO;
    }
    public static Account AccountDTOToAccount(AccountDTO accountDTO) {
        Account account = new Account(accountDTO.accountNumberDTO);
        return account;
    }
}
