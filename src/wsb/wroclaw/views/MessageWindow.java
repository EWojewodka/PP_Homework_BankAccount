package wsb.wroclaw.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import wsb.wroclaw.entity.BankAccount;
import wsb.wroclaw.manager.BankManager;

@SuppressWarnings("serial")
public class MessageWindow extends JPanel implements ActionListener {

	public MessageWindow() {
		BankManager.getInstance().getViewsManager().setMessageWindow(this);
		setVisible(true);
		setBackground(Color.GRAY);
		setForeground(Color.WHITE);
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(400, 400));
		add(new CreateAccountButton("Create account", this));
		add(new LoginButton("Login", this));
		add(new LogoutButton("Logout", this));
		add(new PaymentButton("Payment", this));
		add(new WithdrawButton("Withdraw", this));
		add(new TransferButton("Transfer", this));
		add(new ChangeDebtButton("Change debt", this));
		Timer timer = new Timer(100, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Monospaced", Font.BOLD, 13));
		if (BankManager.getInstance().getAccountManager().getLoggedAccount() != null) {
			BankAccount loggedAccount = BankManager.getInstance().getAccountManager().getLoggedAccount();
			g.drawString("Logged: " + loggedAccount.getCustomerNumber() + " Amount: " + loggedAccount.getAmount()
					+ " Debt: " + loggedAccount.getDebt(), 10, 350);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		revalidate();
	}

}
