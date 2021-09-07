package za.ac.nwu.acsys.logic.flow;

import za.ac.nwu.acsys.domain.dto.AccountTypeDto;

import java.util.List;

public interface FetchAccountTypeFlow {

    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);
}
