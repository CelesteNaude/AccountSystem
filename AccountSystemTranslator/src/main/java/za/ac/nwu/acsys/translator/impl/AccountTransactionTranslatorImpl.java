package za.ac.nwu.acsys.translator.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;
import za.ac.nwu.acsys.domain.persistence.AccountTransaction;
import za.ac.nwu.acsys.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.acsys.translator.AccountTransactionTranslator;


@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private final AccountTransactionRepository accountTransactionRepository;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }


    @Override
    public AccountTransactionDto getAccountTransaxById(Long transactionId) {
        try{
            AccountTransaction accountTransaction = accountTransactionRepository.getAccountTransaxById(transactionId);
            return new AccountTransactionDto(accountTransaction);
        }catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountTransaction save(AccountTransaction accountTransaction) {
        try{
            return accountTransactionRepository.save(accountTransaction);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }
}
