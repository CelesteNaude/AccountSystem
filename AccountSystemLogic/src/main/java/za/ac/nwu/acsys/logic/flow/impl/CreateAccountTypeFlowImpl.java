package za.ac.nwu.acsys.logic.flow.impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.acsys.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;


@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    // Override creation date -> in AccountTypeDto it can be null
    @Override
    public AccountTypeDto create(AccountTypeDto accountType) {
        if (null == accountType.getCreationDate()) { // always put the "null" first to avoid null pointers
            accountType.setCreationDate(LocalDate.now());
        }
        return accountTypeTranslator.create(accountType);
    }
}
