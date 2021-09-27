package za.ac.nwu.acsys.logic.flow.impl;

// checked

import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;
import za.ac.nwu.acsys.domain.persistence.AccountTransaction;
import za.ac.nwu.acsys.domain.persistence.AccountType;
import za.ac.nwu.acsys.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.acsys.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.acsys.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    public  CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
                                             FetchAccountTypeFlow fetchAccountTypeFlow) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this. fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

//    @Override
//    public AccountTransactionDto create(AccountTransactionDto accountTransactionDto) {
//        accountTransactionDto.setTransactionId(null);//if transactionId was populated
//
//        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountTypeMnemonic());
//        AccountTransaction accountTransaction = accountTransactionDto.buildAccountTransaction(accountType);
//
//        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);
//
//        return new AccountTransactionDto(createdAccountTransaction);
//    }
}
