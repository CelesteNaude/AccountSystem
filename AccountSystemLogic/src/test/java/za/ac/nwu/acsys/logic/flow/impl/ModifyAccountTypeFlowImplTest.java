package za.ac.nwu.acsys.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.translator.AccountTypeTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ModifyAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator translator;

    @InjectMocks
    private ModifyAccountTypeFlowImpl modifyFlow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deleteAccountType() {
        AccountTypeDto accountTypeDto = new AccountTypeDto("mnemonic", "Name", LocalDate.parse("2020-01-01"));
        when(modifyFlow.deleteAccountType(anyString())).thenReturn(accountTypeDto);
        modifyFlow.deleteAccountType(accountTypeDto.getMnemonic());
        verify(translator, times(1)).deleteAccountType(any(String.class));
    }

    @Test
    public void updateAccountType() {
        AccountTypeDto accountTypeDto = new AccountTypeDto("mnemonic", "Name", LocalDate.parse("2020-01-01"));
        when(modifyFlow.updateAccountType(anyString(), anyString(), any(LocalDate.class))).thenReturn(accountTypeDto);
        modifyFlow.updateAccountType(accountTypeDto.getMnemonic(), accountTypeDto.getAccountTypeName(), accountTypeDto.getCreationDate());
        verify(translator, times(1)).updateAccountType(accountTypeDto.getMnemonic(), accountTypeDto.getAccountTypeName(), accountTypeDto.getCreationDate());
    }
}