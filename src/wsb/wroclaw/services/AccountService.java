package wsb.wroclaw.services;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import wsb.wroclaw.entity.BankAccount;
import wsb.wroclaw.manager.BankManager;
import wsb.wroclaw.utils.CheckDigits;

public class AccountService {

	public void createAccountSerive(String password) {
		if (password.length() >= 8) {
			BankAccount account = new BankAccount(String.valueOf(password));
			BankManager.getInstance().getAccountManager().addNewAccount(account);
			JOptionPane.showMessageDialog(null,
					"Your customer number is: " + account.getCustomerNumber()
							+ "\nYour debt default is set on 0$. Be careful",
					"Account created!", JOptionPane.PLAIN_MESSAGE);
		} else if (password.length() < 8 && password.length() > 0) {
			JOptionPane.showMessageDialog(null, "Your password must be longer or equals than 8 chars.");
		}
	}

	public void loginService() {
		String customerNumber = JOptionPane.showInputDialog("Enter your customer number");
		if (customerNumber != null && customerNumber.length() > 0) {
			BankAccount account = BankManager.getInstance().getAccountManager()
					.findByCustomerNumber(Integer.parseInt(customerNumber));
			JPasswordField passwordField = new JPasswordField();
			JOptionPane.showConfirmDialog(null, passwordField, "Enter password", JOptionPane.OK_CANCEL_OPTION);
			if (account != null && account.getPassword().equals(String.valueOf(passwordField.getPassword()))) {
				BankManager.getInstance().getAccountManager().setLoggedAccount(account);
				BankManager.getInstance().getViewsManager().buttonToggle();
			}
		}
	}

	public void paymentService() {
		String amount = JOptionPane.showInputDialog("Amount of payment");
		if (amount != null) {
			if (CheckDigits.isOnlyDigits(amount)) {
				BankManager.getInstance().getAccountManager().getLoggedAccount().payment(Integer.parseInt(amount));
			} else {
				JOptionPane.showMessageDialog(null, "Value is not correct. Please use only digits.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void withdrawService() {
		String amount = JOptionPane.showInputDialog("Amount to withdraw");
		if (amount != null) {
			if (CheckDigits.isOnlyDigits(amount)) {
				BankManager.getInstance().getAccountManager().getLoggedAccount().withdraw(Integer.parseInt(amount));
			} else {
				JOptionPane.showMessageDialog(null, "Value is not correct. Please use only digits.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void transferService() {
		String customerNumber = JOptionPane.showInputDialog("Enter customer number to transfer money");
		String amount = JOptionPane.showInputDialog("Amount to transfer");
		if (customerNumber != null && amount != null) {
			if (CheckDigits.isOnlyDigits(customerNumber) && CheckDigits.isOnlyDigits(amount)) {
				if (BankManager.getInstance().getAccountManager().getLoggedAccount()
						.withdraw(Integer.parseInt(amount))) {
					BankManager.getInstance().getAccountManager().findByCustomerNumber(Integer.parseInt(customerNumber))
							.payment(Integer.parseInt(amount));
				}
			} else {
				JOptionPane.showMessageDialog(null, "Value is not correct. Please use only digits.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void changeDebtService() {
		String newDebt = JOptionPane.showInputDialog("Set your new debt");
		if (newDebt != null) {
			if (CheckDigits.isOnlyDigits(newDebt)) {
				BankManager.getInstance().getAccountManager().getLoggedAccount().setDebt(-Integer.parseInt(newDebt));
			} else {
				JOptionPane.showMessageDialog(null, "Value is not correct. Please use only digits.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
