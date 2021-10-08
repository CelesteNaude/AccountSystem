package za.ac.nwu.acsys.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;
import za.ac.nwu.acsys.translator.AccountTransactionTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FetchAccountTransactionFlowImplTest {

    @Mock
    private AccountTransactionTranslator translator;

    @InjectMocks
    private FetchAccountTransactionFlowImpl fetchFlow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAccountTransax() {
        AccountTransactionDto accountTransactionDto = new AccountTransactionDto(1L,"mnemonic", 3L, 1L, 20L, LocalDate.parse("2020-01-01"));
        when(translator.getAccountTransaxById(any(Long.class))).thenReturn(new AccountTransactionDto());
        AccountTransactionDto accountTransactionDto1 = fetchFlow.getAccountTransax(accountTransactionDto.getTransactionId());
        assertNotNull(accountTransactionDto1);
        verify(translator, times(1)).getAccountTransaxById(any(Long.class));
    }
}