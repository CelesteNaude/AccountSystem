package za.ac.nwu.acsys.translator.impl;

// checked

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.domain.persistence.AccountTransaction;
import za.ac.nwu.acsys.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.acsys.translator.AccountTransactionTranslator;


@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private final AccountTransactionRepository repo;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository) {
        this.repo = accountTransactionRepository;
    }


    @Override
    public AccountTransaction save(AccountTransaction accountTransaction) {
        try {
            return  repo.save(accountTransaction);
        }catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }


    @Override
    public AccountTransaction getAccountTransactionByPk(Long transactionId) {
        try {
            return  repo.findById(transactionId).orElse(null);
        }catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }


}
