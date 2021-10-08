package za.ac.nwu.acsys.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;
import za.ac.nwu.acsys.domain.persistence.AccountInfo;
import za.ac.nwu.acsys.domain.persistence.AccountTransaction;
import za.ac.nwu.acsys.translator.AccountTransactionTranslator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTransactionFlowImplTest {

    @Mock
    private AccountTransactionTranslator translator;
    @Mock
    private AccountTransaction transaction;

    @InjectMocks
    private CreateAccountTransactionFlowImpl createFlow;

    @Before
    public void setUp() throws Exception {
        transaction = new AccountTransaction();
    }

    @After
    public void tearDown() throws Exception {
        transaction = null;
    }

    @Test
    public void add() {
    }

    @Test
    public void subtract() {
    }
}