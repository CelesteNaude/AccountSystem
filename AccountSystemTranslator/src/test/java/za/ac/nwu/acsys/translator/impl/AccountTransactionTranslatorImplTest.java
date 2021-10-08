package za.ac.nwu.acsys.translator.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.acsys.domain.dto.AccountInfoDto;
import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;
import za.ac.nwu.acsys.domain.persistence.AccountInfo;
import za.ac.nwu.acsys.domain.persistence.AccountTransaction;
import za.ac.nwu.acsys.repo.persistence.AccountTransactionRepository;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTransactionTranslatorImplTest {

    @Mock
    private AccountTransactionRepository repository;

    @InjectMocks
    private AccountTransactionTranslatorImpl translator;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAccountTransaxById() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto(1L,"mnemonic", 3L, 1L, 20L, LocalDate.parse("2020-01-01"));
        AccountTransaction accountTransaction = repository.getAccountTransaxById(accountTransactionDto.getTransactionId());
        assertNull(accountTransaction);
        verify(repository, times(1)).getAccountTransaxById(any(Long.class));
    }

    @Test
    public void save() {
        AccountTransaction accountTransaction = repository.save(new AccountTransaction());
        assertNull(accountTransaction);
        translator.save(accountTransaction);
        verify(repository, times(1)).save(any(AccountTransaction.class));
    }
}