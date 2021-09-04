package za.ac.nwu.acsys.logic.services.comp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.logic.services.FetchAccountTypeService;
import za.ac.nwu.acsys.translator.AccountTypeTranslator;

import java.util.List;

@Transactional
@Component
public class FetchAccountTypeServiceComp implements FetchAccountTypeService {

    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeServiceComp(AccountTypeTranslator accountTypeTranslator) {
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

}
