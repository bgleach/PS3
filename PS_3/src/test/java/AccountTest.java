import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Accounts.Account;
import Exceptions.InsufficentFundsException;

public class AccountTest {
	Account newAccount = new Account(1122, 20000);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		newAccount.setAnnualInterestRate(4.5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(newAccount.getId(), 1122);
		assertEquals(newAccount.getBalance(), 20000, 0);
		assertEquals(newAccount.getAnnualInterestRate(), 4.5, 0);
		assertEquals(newAccount.getMonthlyInterestRate(), 4.5 / 12, 0);
		System.out.println("Account ID: " + newAccount.getId());
		System.out.println("Account Balance: " + newAccount.getBalance());
		System.out.println("Annual Interest Rate: " + newAccount.getAnnualInterestRate());
		System.out.println("Date Created: " + newAccount.getdateCreated());
	}
	
	@Test
	public void testDeposit(){
		newAccount.deposit(3000);
		assertTrue(newAccount.getBalance()== 23000);
	}
	
	@Test
	public void testWithdraw(){
		Account a = new Account(110,10.00);
		try{
		a.withdraw(100.00);
		}catch(InsufficentFundsException e){
			e.printStackTrace();
			System.out.println("Withdrawl Terminated");
		}
		assertTrue(a.getBalance()==10.00);
		try{
		a.withdraw(10.00);
		}catch(InsufficentFundsException e){
			e.printStackTrace();
			System.out.println("Withdrawl Terminated");
		}
		assertTrue(a.getBalance()==0.00);
	}

}
