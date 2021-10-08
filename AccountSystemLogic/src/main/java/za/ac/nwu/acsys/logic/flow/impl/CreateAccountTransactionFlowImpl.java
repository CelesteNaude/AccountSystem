package za.ac.nwu.acsys.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;
import za.ac.nwu.acsys.domain.persistence.AccountInfo;
import za.ac.nwu.acsys.domain.persistence.AccountTransaction;
import za.ac.nwu.acsys.domain.persistence.AccountType;
import za.ac.nwu.acsys.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.acsys.logic.flow.FetchAccountInfoFlow;
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
    private final FetchAccountInfoFlow fetchAccountInfoFlow;

    public  CreateAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator,
                                             FetchAccountTypeFlow fetchAccountTypeFlow,
                                             FetchAccountInfoFlow fetchAccountInfoFlow) {
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.fetchAccountInfoFlow = fetchAccountInfoFlow;
    }

    @Override
    public AccountTransactionDto add(AccountTransactionDto transactionDto, String creationDate) {
        LOGGER.info("The input object was {}", transactionDto);
        transactionDto.setTransactionId(null);

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(transactionDto.getAccountType());
        LOGGER.info("Got AccountType for {} and the AccountTypeId is {}", transactionDto.getAccountType(), accountType.getMnemonic());

        AccountInfo accountInfo = fetchAccountInfoFlow.getAccountInfoAddById(transactionDto.getAccountInfo(), transactionDto.getAmount());
        LOGGER.info("Got AccountInfo for {} and the AccountInfoId is {}", transactionDto.getAccountInfo(), accountInfo.getAccountInfoId());

        try {
            if(null == creationDate) {
                transactionDto.setTransactionDate(LocalDate.now());
            } else{
                transactionDto.setTransactionDate(LocalDate.parse(creationDate));
            }
        } catch (Exception e) {
            throw new RuntimeException("Date not in correct format 'yyyy-MM-dd'", e);
        }

        AccountTransaction accountTransaction = transactionDto.getAccountTransaction(accountType, accountInfo);
        AccountTransaction createdAccountTransax = accountTransactionTranslator.save(accountTransaction);

        AccountTransactionDto result = new AccountTransactionDto(createdAccountTransax);
        LOGGER.info("The return object is {}", result);
        return result;
    }

    @Override
    public AccountTransactionDto subtract(AccountTransactionDto transactionDto) {
        LOGGER.info("The input object was {}", transactionDto);
        transactionDto.setTransactionId(null);

        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(transactionDto.getAccountType());
        LOGGER.info("Got AccountType for {} and the AccountTypeId is {}", transactionDto.getAccountType(), accountType.getMnemonic());

        AccountInfo accountInfo = fetchAccountInfoFlow.getAccountInfoSubtractById(transactionDto.getAccountInfo(), transactionDto.getAmount());
        LOGGER.info("Got AccountInfo for {} and the AccountInfoId is {}", transactionDto.getAccountInfo(), accountInfo.getAccountInfoId());

        if(null == transactionDto.getTransactionDate()) {
            transactionDto.setTransactionDate(LocalDate.now());
        }

        AccountTransaction accountTransaction = transactionDto.getAccountTransaction(accountType, accountInfo);
        AccountTransaction createdAccountTransax = accountTransactionTranslator.save(accountTransaction);

        AccountTransactionDto result = new AccountTransactionDto(createdAccountTransax);
        LOGGER.info("The return object is {}", result);
        return result;
    }
}
