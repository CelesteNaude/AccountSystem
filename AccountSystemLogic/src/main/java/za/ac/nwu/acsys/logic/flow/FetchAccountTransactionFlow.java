package za.ac.nwu.acsys.logic.flow;

// checked

import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;

public interface FetchAccountTransactionFlow {
    AccountTransactionDto getAccountTransactionById(Long transactionId);
}
