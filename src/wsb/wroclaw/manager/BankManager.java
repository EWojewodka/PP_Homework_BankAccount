package wsb.wroclaw.manager;

public enum BankManager {
	INSTANCE;
	/**
	 * 
	 */
	
	private AccountManager accountManager;
	private ViewsManager viewsManager;

	private BankManager() {
		accountManager = new AccountManager();
		viewsManager = new ViewsManager();
	}

	public static BankManager getInstance() {
		return BankManager.INSTANCE;
	}
	
	public ViewsManager getViewsManager() {
		return viewsManager;
	}

	public AccountManager getAccountManager() {
		return accountManager;
	}
}
