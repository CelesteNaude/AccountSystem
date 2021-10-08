package za.ac.nwu.acsys.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.domain.persistence.AccountType;
import za.ac.nwu.acsys.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.acsys.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        return accountTypeTranslator.getAllAccountTypes();
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic) {
        return accountTypeTranslator.getAccountTypeByMnemonic(mnemonic);
    }

    @Override
    public AccountType getAccountTypeDbEntityByMnemonic(String accountType) {
        return accountTypeTranslator.getAccountTypeDbEntityByMnemonic(accountType);
    }
}
