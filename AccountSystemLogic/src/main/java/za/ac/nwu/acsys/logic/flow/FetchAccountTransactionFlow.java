package za.ac.nwu.acsys.logic.flow;

import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;

public interface FetchAccountTransactionFlow {


    AccountTransactionDto getAccountTransax(Long transactionId);
}
