package wsb.wroclaw.manager;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import wsb.wroclaw.views.AbstractButton;

public class ViewsManager {

	private JPanel messageWindow;
	private JFrame bankFrame;
	private List<AbstractButton> buttonsList;

	public ViewsManager() {
		buttonsList = new ArrayList<>();
	}

	public void addButton(AbstractButton button) {
		buttonsList.add(button);
	}

	public void removeButton(AbstractButton button) {
		buttonsList.remove(button);
	}

	public JPanel getMessageWindow() {
		return messageWindow;
	}

	@SuppressWarnings("deprecation")
	public void buttonToggle() {
		for (AbstractButton button : buttonsList) {
			if (button.isShowing()) {
				button.hide();
			} else {
				button.show();
			}
		}
	}

	public void setMessageWindow(JPanel messageWindow) {
		this.messageWindow = messageWindow;
	}

	public JFrame getBankFrame() {
		return bankFrame;
	}

	public void setBankFrame(JFrame bankFrame) {
		this.bankFrame = bankFrame;
	}

}
