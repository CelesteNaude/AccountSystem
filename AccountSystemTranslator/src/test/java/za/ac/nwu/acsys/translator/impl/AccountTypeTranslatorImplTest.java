package za.ac.nwu.acsys.translator.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.domain.persistence.AccountInfo;
import za.ac.nwu.acsys.domain.persistence.AccountType;
import za.ac.nwu.acsys.repo.persistence.AccountTypeRepository;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountTypeTranslatorImplTest {

    @Mock
    private AccountTypeRepository repository;

    @InjectMocks
    private AccountTypeTranslatorImpl translator;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllAccountTypes() {
    }

    @Test
    public void create() {
        AccountType accountType = repository.save(new AccountTypeDto().getAccountType());
        assertNull(accountType);
        verify(repository, times(1)).save(any(AccountType.class));
    }

    @Test
    public void getAccountTypeByMnemonic() {
        AccountTypeDto accountTypeDto = new AccountTypeDto("mnemonic", "Name", LocalDate.parse("2020-01-01"));
        AccountType accountType = repository.getAccountTypeByMnemonic(accountTypeDto.getMnemonic());
        assertNull(accountType);
        verify(repository, times(1)).getAccountTypeByMnemonic(any(String.class));
    }

    @Test
    public void getAccountTypeDtoByMnemonic() {
        AccountTypeDto accountTypeDto = new AccountTypeDto("mnemonic", "Name", LocalDate.parse("2020-01-01"));
        AccountTypeDto accountTypeDto1 = repository.getAccountTypeDtoByMnemonic(accountTypeDto.getMnemonic());
        assertNull(accountTypeDto1);
        verify(repository, times(1)).getAccountTypeDtoByMnemonic(any(String.class));
    }

    @Test
    public void getAccountTypeDbEntityByMnemonic() {
        AccountTypeDto accountTypeDto = new AccountTypeDto("mnemonic", "Name", LocalDate.parse("2020-01-01"));
        AccountType accountType = repository.getAccountTypeByMnemonic(accountTypeDto.getMnemonic());
        assertNull(accountType);
        verify(repository, times(1)).getAccountTypeByMnemonic(any(String.class));
    }

    @Test
    public void updateAccountType() {
        AccountTypeDto accountTypeDto = new AccountTypeDto("mnemonic", "Name", LocalDate.parse("2020-01-01"));
        repository.updateAccountType(accountTypeDto.getMnemonic(), accountTypeDto.getAccountTypeName(), accountTypeDto.getCreationDate());
        AccountTypeDto accountTypeDto1 = repository.getAccountTypeDtoByMnemonic(accountTypeDto.getMnemonic());
        assertNull(accountTypeDto1);
        verify(repository, times(1)).updateAccountType("mnemonic", "Name", LocalDate.parse("2020-01-01"));
        verify(repository, times(1)).getAccountTypeDtoByMnemonic(any(String.class));
    }

    @Test
    public void deleteAccountType() {
        AccountTypeDto accountTypeDto = new AccountTypeDto("mnemonic", "Name", LocalDate.parse("2020-01-01"));
        repository.deleteAccountType(accountTypeDto.getMnemonic());
        AccountTypeDto accountTypeDto1 = repository.getAccountTypeDtoByMnemonic(accountTypeDto.getMnemonic());
        assertNull(accountTypeDto1);
        verify(repository, times(1)).deleteAccountType("mnemonic");
        verify(repository, times(1)).getAccountTypeDtoByMnemonic(any(String.class));
    }
}