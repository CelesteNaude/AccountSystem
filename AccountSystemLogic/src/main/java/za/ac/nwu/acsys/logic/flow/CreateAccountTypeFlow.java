package za.ac.nwu.acsys.logic.flow;

import za.ac.nwu.acsys.domain.dto.AccountTypeDto;

public interface CreateAccountTypeFlow {

    AccountTypeDto create(AccountTypeDto accountType);

}
