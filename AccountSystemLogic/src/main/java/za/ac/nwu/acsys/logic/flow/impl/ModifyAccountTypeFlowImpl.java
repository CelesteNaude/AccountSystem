package za.ac.nwu.acsys.logic.flow.impl;


import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.logic.flow.ModifyAccountTypeFlow;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class ModifyAccountTypeFlowImpl implements ModifyAccountTypeFlow {
    @Override
    public AccountTypeDto deleteAccountType(String mnemonic) {
        return null;
    }

    @Override
    public AccountTypeDto updateAccountType(String mnemonic, String newAccountTypeName, LocalDate newCreationDate) {
        return null;
    }
}
