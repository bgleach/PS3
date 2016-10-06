package Accounts;
import java.util.Date;
import Exceptions.InsufficentFundsException;

public class Account {

	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated = new Date();
	
	public Account() {
	}
	
	public Account(int id, double balance){
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public Date getdateCreated() {
		return dateCreated;
	}
	
	public double getMonthlyInterestRate() {
		return annualInterestRate/12;
	}
	
	public double withdraw(double amount) throws InsufficentFundsException {
		if (amount <= balance) {
			balance = balance - amount;
		}
		else 
			throw new InsufficentFundsException();
		return balance;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
}
