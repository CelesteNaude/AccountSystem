package za.ac.nwu.acsys.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.acsys.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;


@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTypeFlowImpl.class);

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
        LOGGER.info("The input object was {}", accountType); // {} is a placeholder

        return accountTypeTranslator.create(accountType);
    }
}
