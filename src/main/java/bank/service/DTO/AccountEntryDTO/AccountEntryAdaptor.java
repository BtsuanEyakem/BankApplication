package bank.service.DTO.AccountEntryDTO;

import bank.domain.AccountEntry;
import bank.repository.AccountJRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class AccountEntryAdaptor {
    @Autowired
    AccountJRepository accountJRepository;

    public static AccountEntryDTO AccountEntryDTOfromAccountEntry(AccountEntry accountEntry){
        AccountEntryDTO accountEntryDTO =
                new AccountEntryDTO(accountEntry.getDate(), accountEntry.getAmount(), accountEntry.getDescription(), accountEntry.getFromAccountNumber(), accountEntry.getFromPersonName());
        return accountEntryDTO;
    }
    public static AccountEntry AccountEntryfromAccountEntryDTO(AccountEntryDTO accountEntryDTO){
        AccountEntry accountEntry =
                new AccountEntry(accountEntryDTO.getDate(), accountEntryDTO.getAmount(), accountEntryDTO.getDescription(), accountEntryDTO.getFromAccountNumber(), accountEntryDTO.getFromPersonName());
        return accountEntry;
    }

    public static Collection<AccountEntryDTO> AccountEntryDTOfromAccountEntryList(Collection<AccountEntry> accountEntryList){
        Collection<AccountEntryDTO> accountEntryDTOList = new ArrayList<>();
        for (AccountEntry accountEntry : accountEntryList) {
            accountEntryDTOList.add(AccountEntryDTOfromAccountEntry(accountEntry));
        }
        return accountEntryDTOList;
    }
}
