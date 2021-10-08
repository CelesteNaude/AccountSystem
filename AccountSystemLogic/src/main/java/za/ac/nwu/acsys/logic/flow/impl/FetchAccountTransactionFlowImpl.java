package za.ac.nwu.acsys.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;
import za.ac.nwu.acsys.logic.flow.FetchAccountTransactionFlow;
import za.ac.nwu.acsys.translator.AccountTransactionTranslator;
import za.ac.nwu.acsys.translator.AccountTypeTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class FetchAccountTransactionFlowImpl implements FetchAccountTransactionFlow {

    private AccountTransactionTranslator accountTransactionTranslator;
    private AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
                                           AccountTypeTranslator accountTypeTranslator) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.accountTypeTranslator = accountTypeTranslator;
    }


    @Override
    public AccountTransactionDto getAccountTransax(Long transactionId) {
        return accountTransactionTranslator.getAccountTransaxById(transactionId);
    }
}
