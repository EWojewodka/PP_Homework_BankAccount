package wsb.wroclaw.views;

import java.awt.event.ActionListener;

import wsb.wroclaw.services.AccountService;

@SuppressWarnings("serial")
public class LoginButton extends AbstractButton {

	public LoginButton(String content, ActionListener actionListener) {
		super(content, actionListener);
	}

	@Override
	public void onClick() {
		new AccountService().loginService();
	}

}
