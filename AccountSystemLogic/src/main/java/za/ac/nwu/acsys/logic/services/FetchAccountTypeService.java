package za.ac.nwu.acsys.logic.services;

import za.ac.nwu.acsys.domain.dto.AccountTypeDto;

import java.util.List;

public interface FetchAccountTypeService {

    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
}
