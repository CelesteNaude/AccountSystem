package za.ac.nwu.acsys.repo.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.domain.persistence.AccountType;
import za.ac.nwu.acsys.repo.config.RepositoryTestConfig;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfig.class}) // very important
public class AccountTypeRepositoryTest {

    @Autowired
    AccountTypeRepository accountTypeRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAccountTypeByMnemonic() {
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonic("R");
        assertNull(miles);
    }

    @Test
    public void getAccountTypeByMnemonicMiles() {
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonic("MILES");
        assertNotNull(miles);
        assertEquals("MILES", miles.getMnemonic());
    }

    @Test
    public void getAccountTypeByMnemonicPlay() {
        AccountType miles = accountTypeRepository.getAccountTypeByMnemonic("PLAYS");
        assertNotNull(miles);
        assertEquals("PLAYS", miles.getMnemonic());
    }

    @Test
    public void getAccountTypeDtoByMnemonic() {
        AccountTypeDto miles = accountTypeRepository.getAccountTypeDtoByMnemonic("R");
        assertNull(miles);
    }

    @Test
    public void getAccountTypeDtoByMnemonicMiles() {
        AccountTypeDto miles = accountTypeRepository.getAccountTypeDtoByMnemonic("MILES");
        assertNotNull(miles);
        assertEquals("MILES", miles.getMnemonic());
    }

    @Test
    public void getAccountTypeDtoByMnemonicPlay() {
        AccountTypeDto miles = accountTypeRepository.getAccountTypeDtoByMnemonic("PLAYS");
        assertNotNull(miles);
        assertEquals("PLAYS", miles.getMnemonic());
    }
}