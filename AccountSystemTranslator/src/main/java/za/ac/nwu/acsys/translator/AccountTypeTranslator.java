package za.ac.nwu.acsys.translator;

import za.ac.nwu.acsys.domain.dto.AccountTypeDto;

import java.util.List;

public interface AccountTypeTranslator {

    List<AccountTypeDto> getAllAccountTypes();

    AccountTypeDto create(AccountTypeDto accountType);

    AccountTypeDto getAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);
}
