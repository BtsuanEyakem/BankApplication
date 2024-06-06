package bank.service.DTO.AccountEntryDTO;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AccountEntryDTO {
    private Date date;

    private double amount;

    private String description;

    private String fromAccountNumber;

    private String fromPersonName;

}
