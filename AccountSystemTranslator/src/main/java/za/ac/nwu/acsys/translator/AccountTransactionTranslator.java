package za.ac.nwu.acsys.translator;

import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;
import za.ac.nwu.acsys.domain.persistence.AccountTransaction;

public interface AccountTransactionTranslator {

    AccountTransactionDto getAccountTransaxById(Long transactionId);

    AccountTransaction save(AccountTransaction accountTransaction);
}
