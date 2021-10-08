package za.ac.nwu.acsys.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.translator.AccountTypeTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeFlowImplTest {

    // Mock translator: easy way
    @Mock
    private AccountTypeTranslator translator;

    @InjectMocks
    private CreateAccountTypeFlowImpl flow;


    // Mock translator: hard way
    @Before
    public void setUp() throws Exception {
//        translator = Mockito.mock(AccountTypeTranslator.class);
//        flow = new CreateAccountTypeFlowImpl(translator);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        flow.create(new AccountTypeDto());

        AccountTypeDto accountTypeDto = new AccountTypeDto("mnemonic", "Name", LocalDate.parse("2020-01-01"));



        assertNotNull(accountTypeDto);
        assertEquals(LocalDate.parse("2020-01-01"), accountTypeDto.getCreationDate());

        verify(translator, times(1)).create(any(AccountTypeDto.class));


//        when(translator.create(any(AccountTypeDto.class))).thenReturn(new AccountTypeDto());
//        when(translator.create(eq(accountTypeDto))).thenReturn(accountTypeDto2);
//        when(translator.create(any(AccountTypeDto.class))).then(returnsFirstArg());
//        when(translator.create(any(AccountTypeDto.class))).thenThrow(new RuntimeException());
//        try {
//
//            AccountTypeDto result = flow.create(new AccountTypeDto());
//
//
//            flow.create(new AccountTypeDto());
//            fail("Should throw an exception");
//
//
//        assertNotNull(result);
//        assertEquals(LocalDate.now(), result.getCreationDate());
//
//
//        } catch (Exception e) {
//        }


//        verify(translator).create(any(AccountTypeDto.class));
//         Check if create method gets called once
//        verify(translator, times(1)).create(any(AccountTypeDto.class));
//         Check if create method never gets called
//        verify(translator, never()).create(any(AccountTypeDto.class));
//         Check if create method gets called at least once
//        verify(translator, atLeastOnce()).create(any(AccountTypeDto.class));
//        verify(translator, times(1)).create(eq(accountTypeDto));


//        verify(translator, never()).create(any(AccountTypeDto.class));
    }
}