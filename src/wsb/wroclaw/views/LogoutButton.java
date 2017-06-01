package wsb.wroclaw.views;

import java.awt.event.ActionListener;

import wsb.wroclaw.manager.BankManager;

@SuppressWarnings("serial")
public class LogoutButton extends AbstractButton {

	@SuppressWarnings("deprecation")
	public LogoutButton(String content, ActionListener actionListener) {
		super(content, actionListener);
		this.hide();
	}

	@Override
	public void onClick() {
		BankManager.getInstance().getAccountManager().setLoggedAccount(null);
		BankManager.getInstance().getViewsManager().buttonToggle();
	}

}
