package za.ac.nwu.acsys.repo.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.nwu.acsys.domain.persistence.AccountTransaction;
import za.ac.nwu.acsys.repo.config.RepositoryTestConfig;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfig.class}) // very important
public class AccountTransactionRepositoryTest {

    @Autowired
    AccountTransactionRepository accountTransactionRepo;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAccountTransaxById() {
        AccountTransaction transaction = accountTransactionRepo.getAccountTransaxById(1L);
        assertNull(transaction);
    }

    @Test
    public void getAccountTransaxById4() {
        AccountTransaction transaction = accountTransactionRepo.getAccountTransaxById(4L);
        assertNotNull(transaction);
        assertEquals((Long) 4L, transaction.getTransactionId());
    }
}