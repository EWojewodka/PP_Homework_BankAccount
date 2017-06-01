package wsb.wroclaw.manager;

import java.util.ArrayList;
import java.util.List;

import wsb.wroclaw.entity.BankAccount;

public class AccountManager {

	private List<BankAccount> listOfAccounts;
	private BankAccount loggedAccount;

	public AccountManager() {
		listOfAccounts = new ArrayList<>();
	}

	public List<BankAccount> getListOfAccounts() {
		return listOfAccounts;
	}

	public void addNewAccount(BankAccount account) {
		listOfAccounts.add(account);
	}

	public BankAccount getLoggedAccount() {
		return loggedAccount;
	}

	public void setLoggedAccount(BankAccount loggedAccount) {
		this.loggedAccount = loggedAccount;
	}

	public BankAccount findByCustomerNumber(int number) {
		for (BankAccount account : listOfAccounts) {
			if (account.getCustomerNumber() == number) {
				return account;
			}
		}
		return null;
	}

}
