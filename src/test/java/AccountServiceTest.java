import java.util.List;

import org.junit.Test;

import com.lti.entity.Account;
import com.lti.entity.Transaction;
import com.lti.service.AccountService;

public class AccountServiceTest {
	@Test
	public void openAccount() {
		AccountService service = new AccountService();
		Account account = new Account();
		account.setAcNo(126);
		account.setAc_type("SAVINGS");
		account.setName("Nihal Bhardwaj");
		account.setBalance(35000);
		
		service.openAccount(account);		
	}
	
	@Test
	public void withdraw() {
		AccountService service = new AccountService();
		service.withdraw(123, 5000);
	}
	
	@Test
	public void deposit() {
		AccountService service = new AccountService();
		service.deposit(123, 500000);
	}
	
	@Test
	public void transfer() {
		AccountService service = new AccountService();
		service.transfer(123, 124, 1000);
	}
	
	@Test
	public void balance() {
		AccountService service = new AccountService();
		System.out.println(service.balance(123));
	}
	@Test
	public void miniStatement() {
		AccountService service = new AccountService();
		List<Transaction> list = service.miniStatement(123);
		
		for(Transaction i: list) {
			System.out.println(i.getTxNo() + " , " + i.getAmount() + " , " + i.getTx_type() + " , " + i.getDataAndTime() + " , " + i.getAccount().getAcNo());
		}
	}
	
	
}
