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
public class CreateAccountInfoFlowImplTest {

    @Mock
    private AccountInfoTranslator translator;
    @Mock
    private AccountType accountType;
    @Mock
    private AccountInfo accountInfo;

    @InjectMocks
    private CreateAccountInfoFlowImpl createFlow;
    @InjectMocks
    private FetchAccountTypeFlowImpl fetchTypeFlow;

    @Before
    public void setUp() throws Exception {
        accountType = new AccountType();
        accountInfo = new AccountInfo();
    }

    @After
    public void tearDown() throws Exception {
        accountType = null;
        accountInfo = null;
    }

    @Test
    public void create() {
    }
}