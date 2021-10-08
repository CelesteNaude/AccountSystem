package za.ac.nwu.acsys.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.domain.persistence.AccountType;
import za.ac.nwu.acsys.translator.AccountTypeTranslator;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FetchAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator translator;

    @InjectMocks
    private FetchAccountTypeFlowImpl fetchFlow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllAccountTypes() {
//        fetchFlow.getAllAccountTypes(new List<AccountTypeDto()>);
//        AccountTypeDto accountTypeDto = new AccountTypeDto("mnemonic", "Name", LocalDate.parse("2020-01-01"));
//        verify(translator, times(1)).getAllAccountTypes(List<AccountTypeDto>);
    }

    @Test
    public void getAccountTypeByMnemonic() {
        AccountTypeDto accountTypeDto = new AccountTypeDto("mnemonic", "Name", LocalDate.parse("2020-01-01"));
        assertNotNull(accountTypeDto);
        when(translator.getAccountTypeByMnemonic(any(String.class))).thenReturn(new AccountTypeDto());
        AccountTypeDto accountTypeDto1 = fetchFlow.getAccountTypeByMnemonic(accountTypeDto.getMnemonic());
        assertNotNull(accountTypeDto1);
        verify(translator, times(1)).getAccountTypeByMnemonic(any(String.class));
    }

    @Test
    public void getAccountTypeDbEntityByMnemonic() {
        AccountType accountType = new AccountType(1L,"mnemonic", "Name", LocalDate.parse("2020-01-01"));
        when(translator.getAccountTypeDbEntityByMnemonic(any(String.class))).thenReturn(new AccountType());
        AccountType accountType1 = fetchFlow.getAccountTypeDbEntityByMnemonic(accountType.getMnemonic());
        assertNotNull(accountType1);
        verify(translator, times(1)).getAccountTypeDbEntityByMnemonic(any(String.class));
    }
}