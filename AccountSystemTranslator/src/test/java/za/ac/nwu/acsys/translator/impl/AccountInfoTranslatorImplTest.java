package za.ac.nwu.acsys.translator.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.acsys.domain.dto.AccountInfoDto;
import za.ac.nwu.acsys.domain.persistence.AccountInfo;
import za.ac.nwu.acsys.domain.persistence.AccountType;
import za.ac.nwu.acsys.repo.persistence.AccountInfoRepository;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountInfoTranslatorImplTest {

    @Mock
    private AccountInfoRepository repository;

    @InjectMocks
    private AccountInfoTranslatorImpl translator;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() {
        AccountInfo accountInfo = repository.save(new AccountInfo());
        assertNull(accountInfo);
        translator.save(accountInfo);
        verify(repository, times(1)).save(any(AccountInfo.class));
    }

    @Test
    public void getAccountBalanceById() {
        AccountInfoDto accountInfoDto = new AccountInfoDto(1L, "mnemonic", 3L, 100L);
        AccountInfo accountInfo = repository.getAccountBalanceById(accountInfoDto.getAccountInfoId());
        assertNull(accountInfo);
        verify(repository, times(1)).getAccountBalanceById(any(Long.class));
    }

    @Test
    public void getAccountInfoDbEntityById() {
        AccountInfo accountInfo = repository.getAccountBalanceById(1L);
        assertNull(accountInfo);
        verify(repository, times(1)).getAccountBalanceById(1L);
    }

    @Test
    public void getAccountInfoAddById() {
        AccountInfoDto accountInfoDto = new AccountInfoDto(1L, "mnemonic", 3L, 100L);
        repository.updateAccountAddBalanceById(accountInfoDto.getAccountInfoId(), 20L);
        AccountInfo accountInfo = repository.getAccountBalanceById(accountInfoDto.getAccountInfoId());
        assertNull(accountInfo);
        verify(repository, times(1)).updateAccountAddBalanceById(accountInfoDto.getAccountInfoId(), 20L);
        verify(repository, times(1)).getAccountBalanceById(accountInfoDto.getAccountInfoId());
    }

    @Test
    public void getAccountInfoSubtractById() {
        AccountInfoDto accountInfoDto = new AccountInfoDto(1L, "mnemonic", 3L, 100L);
        repository.updateAccountSubtractBalanceById(accountInfoDto.getAccountInfoId(), 20L);
        AccountInfo accountInfo = repository.getAccountBalanceById(accountInfoDto.getAccountInfoId());
        assertNull(accountInfo);
        verify(repository, times(1)).updateAccountSubtractBalanceById(accountInfoDto.getAccountInfoId(), 20L);
        verify(repository, times(1)).getAccountBalanceById(accountInfoDto.getAccountInfoId());
    }
}