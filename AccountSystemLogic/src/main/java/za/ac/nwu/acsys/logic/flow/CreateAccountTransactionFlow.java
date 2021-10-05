package za.ac.nwu.acsys.logic.flow;

import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;

public interface CreateAccountTransactionFlow {
    AccountTransactionDto create(AccountTransactionDto transactionDto);

    AccountTransactionDto add(AccountTransactionDto accountTransaction);

    AccountTransactionDto subtract(AccountTransactionDto accountTransaction);
}
