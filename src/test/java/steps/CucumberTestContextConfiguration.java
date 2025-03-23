package steps;

import com.bank_account.BankAccountApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = BankAccountApplication.class)
public class CucumberTestContextConfiguration {

}
