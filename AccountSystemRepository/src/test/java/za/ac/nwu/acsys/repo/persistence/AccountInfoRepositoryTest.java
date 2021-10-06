package za.ac.nwu.acsys.repo.persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.nwu.acsys.domain.persistence.AccountInfo;
import za.ac.nwu.acsys.repo.config.RepositoryTestConfig;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfig.class}) // very important
public class AccountInfoRepositoryTest {

    @Autowired
    AccountInfoRepository accountInfoRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAccountBalanceById() {
        AccountInfo id = accountInfoRepository.getAccountBalanceById(4L);
        assertNull(id);
    }

    @Test
    public void getAccountBalanceById3() {
        AccountInfo id = accountInfoRepository.getAccountBalanceById(3L);
        assertNotNull(id);
        assertEquals((Long)3L, id.getAccountInfoId());
    }

    @Test
    public void updateAccountAddBalanceById() {
        accountInfoRepository.updateAccountAddBalanceById(3L, 10L);
        AccountInfo balance = accountInfoRepository.getAccountBalanceById(3L);
        assertEquals((Long) 110L, balance.getBalance());
    }

    @Test
    public void updateAccountSubtractBalanceById() {
        accountInfoRepository.updateAccountSubtractBalanceById(3L, 10L);
        AccountInfo balance = accountInfoRepository.getAccountBalanceById(3L);
        assertEquals((Long) 90L, balance.getBalance());
    }
}