package onlinebanking.service;

import onlinebanking.dao.AccountDao;
import onlinebanking.dao.DaoFactory;
import onlinebanking.model.AccountModel;

/**
 * 
 * @author Ahmed youssef
 *
 */
public class AccountService {

	private AccountDao accountDao;

	AccountService() {
		accountDao = DaoFactory.getAcountDao();
	}

	public void createAccount(AccountModel accountModel) {
		accountDao.add(accountModel);
	}

	public AccountModel findAccount(long accountNumber) {
		return accountDao.find(accountNumber);
	}

	/**
	 * Make deposit transaction
	 * 
	 * @param accountNumber
	 * @param depositAmount
	 * @return {@link AccountModel} after deposit transaction
	 */
	public AccountModel deposit(long accountNumber, double depositAmount) {

		AccountModel accountModel = accountDao.find(accountNumber);
		accountModel.setAmount(accountModel.getAmount() + depositAmount);

		return accountModel;
	}

	/**
	 * Make withdraw transaction
	 * 
	 * @param accountNumber
	 * @param withdrawAmount
	 * @return {@link AccountModel} after withdraw transaction
	 */
	public AccountModel withdraw(long accountNumber, double withdrawAmount) {

		AccountModel accountModel = accountDao.find(accountNumber);

		if (accountModel.getAmount() >= withdrawAmount) {
			accountModel.setAmount(accountModel.getAmount() - withdrawAmount);
			return accountModel;
		} else {
			return null;
		}
	}

	/**
	 * Check that is password is correct for {@link AccountModel}
	 * 
	 * @param accountModel
	 * @param password
	 * @return
	 */
	public boolean correctPassword(AccountModel accountModel, String password) {

		return accountModel.getPassword().equals(password);
	}

	/**
	 * Make transfer transaction
	 * 
	 * @param currentAccountNumber
	 * @param targetAccountNumber
	 * @param transferAmount
	 * @return {@link AccountModel} after transfer transaction
	 */
	public AccountModel transfer(long currentAccountNumber, long targetAccountNumber, double transferAmount) {

		AccountModel currentAccount = accountDao.find(currentAccountNumber);

		if (currentAccount.getAmount() < transferAmount)
			return null;

		AccountModel destinationAccount = accountDao.find(targetAccountNumber);

		// Withdraw from current account
		currentAccount.setAmount(currentAccount.getAmount() - transferAmount);

		// Add to destination account
		destinationAccount.setAmount(destinationAccount.getAmount() + transferAmount);

		return currentAccount;

	}
}
