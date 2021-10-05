package za.ac.nwu.acsys.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.domain.dto.AccountInfoDto;
import za.ac.nwu.acsys.domain.persistence.AccountInfo;
import za.ac.nwu.acsys.logic.flow.FetchAccountInfoFlow;
import za.ac.nwu.acsys.translator.AccountInfoTranslator;

import javax.transaction.Transactional;

@Transactional
@Component
public class FetchAccountInfoFlowImpl implements FetchAccountInfoFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(FetchAccountInfoFlowImpl.class);
    private AccountInfoTranslator accountInfoTranslator;

    @Autowired
    public FetchAccountInfoFlowImpl(AccountInfoTranslator accountInfoTranslator) {
        this.accountInfoTranslator = accountInfoTranslator;
    }

    @Override
    public AccountInfo getAccountInfoDbEntityById(Long accountInfo) {
        return accountInfoTranslator.getAccountInfoDbEntityById(accountInfo);
    }

    @Override
    public AccountInfoDto getAccountBalance(Long accountInfoId) {
        return accountInfoTranslator.getAccountBalanceById(accountInfoId);
    }

    @Override
    public AccountInfo getAccountInfoAddById(Long accountInfo, Long amount) {
        return accountInfoTranslator.getAccountInfoAddById(accountInfo, amount);
    }

    @Override
    public AccountInfo getAccountInfoSubtractById(Long accountInfo, Long amount) {
        return accountInfoTranslator.getAccountInfoSubtractById(accountInfo, amount);
    }
}
