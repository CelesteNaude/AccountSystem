package za.ac.nwu.acsys.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.domain.dto.AccountInfoDto;
import za.ac.nwu.acsys.domain.persistence.AccountInfo;
import za.ac.nwu.acsys.domain.persistence.AccountType;
import za.ac.nwu.acsys.logic.flow.CreateAccountInfoFlow;
import za.ac.nwu.acsys.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.acsys.translator.AccountInfoTranslator;

import javax.transaction.Transactional;

@Transactional
@Component("createAccountInfoFlowName")
public class CreateAccountInfoFlowImpl implements CreateAccountInfoFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountInfoFlowImpl.class);

    private final AccountInfoTranslator accountInfoTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    public CreateAccountInfoFlowImpl(AccountInfoTranslator accountInfoTranslator,
                                     FetchAccountTypeFlow fetchAccountTypeFlow) {
        this.accountInfoTranslator = accountInfoTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

    @Override
    public AccountInfoDto create(AccountInfoDto accountInfoDto) {
        accountInfoDto.setAccountInfoId(null);
        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbEntityByMnemonic(accountInfoDto.getAccountType());
        AccountInfo accountInfo = accountInfoDto.getAccountInfo(accountType);
        AccountInfo createdAccountInfo = accountInfoTranslator.save(accountInfo);
        AccountInfoDto result = new AccountInfoDto(createdAccountInfo);
        return result;
    }
}
