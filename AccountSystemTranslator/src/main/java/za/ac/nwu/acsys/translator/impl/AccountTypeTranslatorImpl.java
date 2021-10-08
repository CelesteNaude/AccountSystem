package za.ac.nwu.acsys.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.domain.persistence.AccountType;
import za.ac.nwu.acsys.repo.persistence.AccountTypeRepository;
import za.ac.nwu.acsys.translator.AccountTypeTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {

    private final AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
        try {
            for (AccountType accountType : accountTypeRepository.findAll()) {
                accountTypeDtos.add(new AccountTypeDto(accountType));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read to the DB", e);
        }
        return accountTypeDtos;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountTypeDto) {
        try{
            AccountType accountType = accountTypeRepository.save(accountTypeDto.getAccountType());
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the DB", e);
        }
    }

    @Override
    public AccountTypeDto getAccountTypeByMnemonic(String mnemonic) {
        try{
            AccountType accountType = accountTypeRepository.getAccountTypeByMnemonic(mnemonic);
            return new AccountTypeDto(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic) {
        try{
            return accountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountType getAccountTypeDbEntityByMnemonic(String accountType) {
        try{
            return accountTypeRepository.getAccountTypeByMnemonic(accountType);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountTypeDto updateAccountType(String mnemonic, String newAccountTypeName, LocalDate newCreationDate) {
        try{
            accountTypeRepository.updateAccountType(mnemonic,newAccountTypeName,newCreationDate);
            return accountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic);
        } catch (Exception e) {
            throw new RuntimeException("Unable to update entity in the DB", e);
        }
    }

    @Override
    public AccountTypeDto deleteAccountType(String mnemonic) {
        try{
            accountTypeRepository.deleteAccountType(mnemonic);
            return accountTypeRepository.getAccountTypeDtoByMnemonic(mnemonic);
        } catch (Exception e) {
            throw new RuntimeException("Unable to delete entity from the DB", e);
        }
    }

}
