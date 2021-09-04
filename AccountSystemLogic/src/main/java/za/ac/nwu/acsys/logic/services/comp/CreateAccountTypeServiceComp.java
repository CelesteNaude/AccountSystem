package za.ac.nwu.acsys.logic.services.comp;

import org.springframework.stereotype.Component;
import  za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import  za.ac.nwu.acsys.logic.services.CreateAccountTypeService;
import  za.ac.nwu.acsys.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeServiceName")
public class CreateAccountTypeServiceComp implements CreateAccountTypeService {

    private final AccountTypeTranslator accountTypeTranslator;

    public CreateAccountTypeServiceComp(AccountTypeTranslator accountTypeTranslator) {
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
