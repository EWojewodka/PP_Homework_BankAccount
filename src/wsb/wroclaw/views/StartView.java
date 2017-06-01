package wsb.wroclaw.views;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import wsb.wroclaw.manager.BankManager;

@SuppressWarnings("serial")
public class StartView extends JFrame {

	public StartView() {
		BankManager.getInstance().getViewsManager().setBankFrame(this);
		setTitle("Bank");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLayout(new FlowLayout());
		add(new MessageWindow());

	}

}
