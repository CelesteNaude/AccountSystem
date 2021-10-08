package za.ac.nwu.acsys.web.sb.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.acsys.domain.dto.AccountInfoDto;
import za.ac.nwu.acsys.domain.dto.AccountTransactionDto;
import za.ac.nwu.acsys.logic.flow.*;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountTransactionControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_TRANSACTION_CONTROLLER_URL = APP_URL + "/account-transaction";

    @Mock
    private FetchAccountTransactionFlow fetchAccountTransactionFlowFlow;
    @Mock
    private CreateAccountTransactionFlow createAccountTransactionFlow;

    @InjectMocks
    private AccountTransactionController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void create() throws Exception {

    }

    @Test
    public void subtract() throws Exception {
//        String accountTransaxToBeCreated = "{\"transactionId\":1,\"accountType\":\"MILES\",\"memberId\":3,\"accountInfo\":1,\"amount\":20,\"transactionDate\":[2020,4,1]},";
//        String expectedResponse = "{\"successful\":true,\"payload\":" + "{\"transactionId\":1,\"accountType\":\"MILES\",\"memberId\":3,\"accountInfo\":1,\"amount\":20,\"transactionDate\":[2020,4,1]}}";
//
//        AccountTransactionDto accountTransactionDto = new AccountTransactionDto(1L, "MILES", 3L, 1L, 20L, LocalDate.parse("2020-04-01"));
//
//        when(createAccountTransactionFlow.subtract(eq(accountTransactionDto))).then(returnsFirstArg());
//
//        MvcResult mvcResult = mockMvc.perform(post(ACCOUNT_TRANSACTION_CONTROLLER_URL)
//                        .servletPath(APP_URL)
//                        .accept(MediaType.APPLICATION_JSON)
//                        .content(accountTransaxToBeCreated)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andReturn();
//
//        verify(createAccountTransactionFlow, times(1)).subtract(eq(accountTransactionDto));
//
//        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getAccountTransaction() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":" + "{\"transactionId\":1,\"accountType\":\"MILES\",\"memberId\":3,\"accountInfo\":1,\"amount\":20,\"transactionDate\":[2020,4,1]}}";

        AccountTransactionDto accountTransactionDto = new AccountTransactionDto(1L, "MILES", 3L, 1L, 20L, LocalDate.parse("2020-04-01"));

        when(fetchAccountTransactionFlowFlow.getAccountTransax(1L)).thenReturn(accountTransactionDto);

        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s",
                        ACCOUNT_TRANSACTION_CONTROLLER_URL, 1)))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(fetchAccountTransactionFlowFlow, times(1)).getAccountTransax(eq(accountTransactionDto.getTransactionId()));

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }
}