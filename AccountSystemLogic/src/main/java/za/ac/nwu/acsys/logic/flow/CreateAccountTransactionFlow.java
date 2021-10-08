package za.ac.nwu.acsys.logic.flow;

import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;

public interface CreateAccountTransactionFlow {

    AccountTransactionDto add(AccountTransactionDto accountTransaction, String creationDate);

    AccountTransactionDto subtract(AccountTransactionDto accountTransaction);
}
