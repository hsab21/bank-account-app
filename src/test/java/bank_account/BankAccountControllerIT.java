package bank_account;

import com.bank_account.BankAccountApplication;
import com.bank_account.application.controller.DepositRequest;
import com.bank_account.application.controller.WithdrawRequest;
import com.bank_account.domain.model.service.BankAccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = BankAccountApplication.class)
class BankAccountControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Mock
    private BankAccountService bankAccountService;


    @Test
    void testDepositSuccess() throws Exception {
        mockMvc.perform(post("/account/deposit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new DepositRequest(BigDecimal.valueOf(200)))))
                .andExpect(status().isOk())
                .andExpect(content().string("Dépôt réussi : 200"));
    }


}
