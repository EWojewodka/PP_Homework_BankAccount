package wsb.wroclaw.views;

import java.awt.event.ActionListener;

import wsb.wroclaw.services.AccountService;

@SuppressWarnings("serial")
public class PaymentButton extends AbstractButton {

	@SuppressWarnings("deprecation")
	public PaymentButton(String content, ActionListener actionListener) {
		super(content, actionListener);
		hide();
	}

	@Override
	public void onClick() {
		new AccountService().paymentService();
	}

}
