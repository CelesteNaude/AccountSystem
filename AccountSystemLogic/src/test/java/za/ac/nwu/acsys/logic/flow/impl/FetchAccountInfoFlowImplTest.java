package za.ac.nwu.acsys.logic.flow.impl;

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
import za.ac.nwu.acsys.translator.AccountInfoTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FetchAccountInfoFlowImplTest {

    @Mock
    private AccountInfoTranslator translator;

    @InjectMocks
    private FetchAccountInfoFlowImpl fetchFlow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAccountInfoDbEntityById() {
        AccountType accountType = new AccountType(1L,"mnemonic", "Name", LocalDate.parse("2020-01-01"));
        AccountInfo accountInfo = new AccountInfo(1L, accountType, 3L, 100L);
        when(translator.getAccountInfoDbEntityById(any(Long.class))).thenReturn(new AccountInfo());
        AccountInfo accountInfo1 = fetchFlow.getAccountInfoDbEntityById(accountInfo.getAccountInfoId());
        assertNotNull(accountInfo1);
        verify(translator, times(1)).getAccountInfoDbEntityById(any(Long.class));
    }

    @Test
    public void getAccountBalance() {
        AccountInfoDto accountInfoDto = new AccountInfoDto(1L, "Mnemonic", 3L, 100L);
        when(translator.getAccountBalanceById(any(Long.class))).thenReturn(new AccountInfoDto());
        AccountInfoDto accountInfoDto1 = fetchFlow.getAccountBalance(accountInfoDto.getAccountInfoId());
        assertNotNull(accountInfoDto1);
        verify(translator, times(1)).getAccountBalanceById(any(Long.class));
    }

    @Test
    public void getAccountInfoAddById() {
        AccountType accountType = new AccountType(1L,"mnemonic", "Name", LocalDate.parse("2020-01-01"));
        AccountInfo accountInfo = new AccountInfo(1L, accountType, 3L, 100L);
        when(translator.getAccountInfoAddById(accountInfo.getAccountInfoId(), 50L)).thenReturn(accountInfo);
        AccountInfo accountInfo1 = fetchFlow.getAccountInfoAddById(accountInfo.getAccountInfoId(), 50L);
        assertNotNull(accountInfo1);
        verify(translator, times(1)).getAccountInfoAddById(accountInfo.getAccountInfoId(), 50L);
    }

    @Test
    public void getAccountInfoSubtractById() {
        AccountType accountType = new AccountType(1L,"mnemonic", "Name", LocalDate.parse("2020-01-01"));
        AccountInfo accountInfo = new AccountInfo(1L, accountType, 3L, 100L);
        when(translator.getAccountInfoSubtractById(accountInfo.getAccountInfoId(), 50L)).thenReturn(accountInfo);
        AccountInfo accountInfo1 = fetchFlow.getAccountInfoSubtractById(accountInfo.getAccountInfoId(), 50L);
        assertNotNull(accountInfo1);
        verify(translator, times(1)).getAccountInfoSubtractById(accountInfo.getAccountInfoId(), 50L);
    }
}