package za.ac.nwu.acsys.translator.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.domain.dto.AccountInfoDto;
import za.ac.nwu.acsys.domain.persistence.AccountInfo;
import za.ac.nwu.acsys.repo.persistence.AccountInfoRepository;
import za.ac.nwu.acsys.translator.AccountInfoTranslator;


@Component
public class AccountInfoTranslatorImpl implements AccountInfoTranslator {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountInfoTranslatorImpl.class);

    private final AccountInfoRepository accountInfoRepository;

    @Autowired
    public AccountInfoTranslatorImpl(AccountInfoRepository accountInfoRepository) {
        this.accountInfoRepository = accountInfoRepository;
    }

    @Override
    public AccountInfo save(AccountInfo accountInfo) {
        try{
            return accountInfoRepository.save(accountInfo);
        }catch (Exception e){
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public AccountInfoDto getAccountBalanceById(Long accountInfoId) {
        try{
            AccountInfo accountInfo = accountInfoRepository.getAccountBalanceById(accountInfoId);
            return new AccountInfoDto(accountInfo);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountInfo getAccountInfoDbEntityById(Long accountInfo) {
        try{
            return accountInfoRepository.getAccountBalanceById(accountInfo);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }

    }

    @Override
    public AccountInfo getAccountInfoAddById(Long accountInfo, Long amount) {
        try{
            LOGGER.info("The accountId te update is {} and the amount is {}", accountInfo, amount);
            accountInfoRepository.updateAccountAddBalanceById(accountInfo, amount);
            LOGGER.info("The accountId te get is {}", accountInfo);
            return accountInfoRepository.getAccountBalanceById(accountInfo);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountInfo getAccountInfoSubtractById(Long accountInfo, Long amount) {
        try{
            LOGGER.info("The accountId te update is {} and the amount is {}", accountInfo, amount);
            accountInfoRepository.updateAccountSubtractBalanceById(accountInfo, amount);
            LOGGER.info("The accountId te get is {}", accountInfo);
            return accountInfoRepository.getAccountBalanceById(accountInfo);
        }catch (Exception e){
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
}
