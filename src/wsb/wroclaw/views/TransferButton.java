package wsb.wroclaw.views;

import java.awt.event.ActionListener;

import wsb.wroclaw.services.AccountService;

@SuppressWarnings("serial")
public class TransferButton extends AbstractButton {

	@SuppressWarnings("deprecation")
	public TransferButton(String content, ActionListener actionListener) {
		super(content, actionListener);
		hide();
	}

	@Override
	public void onClick() {
		new AccountService().transferService();
	}

}
