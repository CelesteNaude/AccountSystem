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
import za.ac.nwu.acsys.domain.dto.AccountTypeDto;
import za.ac.nwu.acsys.logic.flow.CreateAccountInfoFlow;
import za.ac.nwu.acsys.logic.flow.FetchAccountInfoFlow;
import za.ac.nwu.acsys.logic.flow.ModifyAccountInfoFlow;

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
public class AccountInfoControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_INFO_CONTROLLER_URL = APP_URL + "/account-info";

    @Mock
    private FetchAccountInfoFlow fetchAccountInfoFlow;
    @Mock
    private CreateAccountInfoFlow createAccountInfoFlow;

    @InjectMocks
    private AccountInfoController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void create() throws Exception {
        String accountInfoToBeCreated = "{\"accountInfoId\":1,\"accountType\":\"MILES\",\"memberId\":3,\"balance\":100},";
        String expectedResponse = "{\"successful\":true,\"payload\":" + "{\"accountInfoId\":1,\"accountType\":\"MILES\",\"memberId\":3,\"balance\":100}}";

        AccountInfoDto accountInfoDto = new AccountInfoDto(1L, "MILES", 3L, 100L);

        when(createAccountInfoFlow.create(eq(accountInfoDto))).then(returnsFirstArg());

        MvcResult mvcResult = mockMvc.perform(post(ACCOUNT_INFO_CONTROLLER_URL)
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(accountInfoToBeCreated)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        verify(createAccountInfoFlow, times(1)).create(eq(accountInfoDto));

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getAccountInfo() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":" + "{\"accountInfoId\":1,\"accountType\":\"MILES\",\"memberId\":3,\"balance\":100}}";

        AccountInfoDto accountInfoDto = new AccountInfoDto(1L, "MILES", 3L, 100L);

        when(fetchAccountInfoFlow.getAccountBalance(1L)).thenReturn(accountInfoDto);

        MvcResult mvcResult = mockMvc.perform(get((String.format("%s/%s",
                        ACCOUNT_INFO_CONTROLLER_URL, 1)))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(fetchAccountInfoFlow, times(1)).getAccountBalance(eq(accountInfoDto.getAccountInfoId()));

        assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString());
    }
}