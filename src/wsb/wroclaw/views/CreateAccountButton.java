package wsb.wroclaw.views;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import wsb.wroclaw.services.AccountService;

@SuppressWarnings("serial")
public class CreateAccountButton extends AbstractButton {

	public CreateAccountButton(String content, ActionListener actionListener) {
		super(content, actionListener);
		
	}

	@Override
	public void onClick() {
		JPasswordField passwordField = new JPasswordField();
		JOptionPane.showConfirmDialog(null, passwordField, "Enter new password", JOptionPane.OK_CANCEL_OPTION);
		new AccountService().createAccountSerive(String.valueOf(passwordField.getPassword()));
	}

}
