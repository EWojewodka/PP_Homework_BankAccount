package wsb.wroclaw.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import wsb.wroclaw.interfaces.ActionForButton;
import wsb.wroclaw.manager.BankManager;

@SuppressWarnings("serial")
public abstract class AbstractButton extends JButton implements ActionListener, ActionForButton {

	private String content;

	public AbstractButton(String content, ActionListener actionListener) {
		this.content = content;
		setText(content);
		setSize(100,50);
		addActionListener(this);
		BankManager.getInstance().getViewsManager().addButton(this);
	}

	public String getContent() {
		return content;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == this) {
			onClick();
		}
	}

}
