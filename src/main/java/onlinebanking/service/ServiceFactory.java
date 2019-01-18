package onlinebanking.service;

/**
 * 
 * @author Ahmed youssef
 *
 */
public final class ServiceFactory {

	private static AccountService accountService;
	private static LoginService loginService;

	static {
		accountService = new AccountService();
		loginService = new LoginService();
	}

	public static AccountService getAccountService() {
		return accountService;
	}

	public static LoginService getLoginService() {
		return loginService;
	}
}
