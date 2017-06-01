package wsb.wroclaw.entity;

import java.util.Random;

import javax.swing.JOptionPane;

public class BankAccount {

	private int amount;
	private int debt;
	private String password;
	private int customerNumber;

	public BankAccount(String password) {
		amount = 0;
		debt = 0;
		customerNumber = new Random().nextInt(99999999 - 10000000) + 10000000;
		this.password = password;
		System.out.println(this);
	}

	public void payment(int amount) {
		if (amount > 10000)
			JOptionPane.showMessageDialog(null, "Your payment is big. We have to inform tax office.", "Warning!",
					JOptionPane.INFORMATION_MESSAGE);
		this.amount += amount;
	}

	public boolean withdraw(int amount) {
		if ((this.amount - amount) >= debt) {
			this.amount -= amount;
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "You have not enough money.", "Warning!",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}

	public int getAmount() {
		return amount;
	}

	public int getDebt() {
		return debt;
	}

	public void setDebt(int debt) {
		this.debt = debt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + customerNumber;
		result = prime * result + debt;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (amount != other.amount)
			return false;
		if (customerNumber != other.customerNumber)
			return false;
		if (debt != other.debt)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BankAccount [amount=" + amount + ", debt=" + debt + ", password=" + password + ", customerNumber="
				+ customerNumber + "]";
	}

}
