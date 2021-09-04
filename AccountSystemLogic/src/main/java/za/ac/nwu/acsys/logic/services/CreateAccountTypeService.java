package za.ac.nwu.acsys.logic.services;

import za.ac.nwu.acsys.domain.dto.AccountTypeDto;

public interface CreateAccountTypeService {
    AccountTypeDto create(AccountTypeDto accountType);
}
