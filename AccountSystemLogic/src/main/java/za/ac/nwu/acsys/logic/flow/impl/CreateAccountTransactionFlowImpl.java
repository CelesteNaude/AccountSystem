package za.ac.nwu.acsys.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.domain.persistence.AccountTransaction;
import za.ac.nwu.acsys.domain.persistence.AccountType;
import za.ac.nwu.acsys.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.acsys.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.acsys.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTransactionFlowName")
public class CreateAccountTransactionFlowImpl implements CreateAccountTransactionFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTransactionFlowImpl.class);

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    public  CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
                                             FetchAccountTypeFlow fetchAccountTypeFlow) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this. fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto transactionDto) {
        transactionDto.setTransactionId(null);
        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(transactionDto.getAccountType());
        if(null == transactionDto.getTransactionDate()) {
            transactionDto.setTransactionDate(LocalDate.now());
        }
        AccountTransaction accountTransaction = transactionDto.getAccountTransaction(accountType);
        AccountTransaction createdAccountTransax = accountTransactionTranslator.save(accountTransaction);
        AccountTransactionDto result = new AccountTransactionDto(createdAccountTransax);
        return result;
    }

//    @Override
//    public  AccountTransactionDto add(AccountTransactionDto accountTransactionDto) {
//        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountType());
//        AccountTransaction accountTransaction = accountTransactionDto.getAccountTransaction(accountType);
//        return accountTransactionTranslator.create(accountTransaction);
//    }

//    @Override
//    public AccountTransactionDto add(AccountTransactionDto accountTransactionDto) {
//        LOGGER.info("The input object was {}", accountTransactionDto);
//
//        accountTransactionDto.setTransactionId(null);//if transactionId was populated
//
//        AccountType accountType =
//                fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountType());
//        LOGGER.info("Got AccountType for {} and the AccountTypeId is {}",
//                accountTransactionDto.getAccountType(), accountType.getMnemonic());
//
//        // Create new balance
//        Long newBalance = accountTransactionDto.getBalance() + accountTransactionDto.getAmount();
//        AccountTransaction accountTransaction =
//                accountTransactionDto.buildAccountTransaction(accountType, newBalance);
//
//         AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);
//
//        AccountTransactionDto result = new AccountTransactionDto(createdAccountTransaction);
//        LOGGER.info("The return object is {}", result);
//        return result;
//    }

//    @Override
//    public AccountTransactionDto subtract(AccountTransactionDto accountTransactionDto) {
//        LOGGER.info("The input object was {}", accountTransactionDto);
//
//        accountTransactionDto.setTransactionId(null);//if transactionId was populated
//
//        AccountType accountType =
//                fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountTransactionDto.getAccountType());
//        LOGGER.info("Got AccountType for {} and the AccountTypeId is {}",
//                accountTransactionDto.getAccountType(), accountType.getMnemonic());
//
//        // Create new balance
//        Long newBalance = accountTransactionDto.getBalance() - accountTransactionDto.getAmount();
//        AccountTransaction accountTransaction =
//                accountTransactionDto.buildAccountTransaction(accountType, newBalance);
//
//        AccountTransaction createdAccountTransaction = accountTransactionTranslator.save(accountTransaction);
//
//        AccountTransactionDto result = new AccountTransactionDto(createdAccountTransaction);
//        LOGGER.info("The return object is {}", result);
//        return result;
//    }
}
