package bank.service.DTO.AccountDTO;

import bank.domain.AccountEntry;
import bank.service.DTO.AccountEntryDTO.AccountEntryDTO;
import bank.service.DTO.CustomerDTO.CustomerDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
@Data
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AccountDTO {
    long accountNumberDTO;
    Collection<AccountEntryDTO> entryListDTO = new ArrayList<AccountEntryDTO>();

    CustomerDTO customerDTO;
    public AccountDTO(long accountNumber){
        this.accountNumberDTO = accountNumber;
    }
    public double getBalance() {
        double balance=0;
        for (AccountEntryDTO entry : entryListDTO) {
            balance+=entry.getAmount();
        }
        return balance;
    }

}
