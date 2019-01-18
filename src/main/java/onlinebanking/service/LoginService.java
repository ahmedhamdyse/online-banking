package onlinebanking.service;

import onlinebanking.dao.AccountDao;

import onlinebanking.dao.DaoFactory;
import onlinebanking.model.AccountModel;

/**
 * 
 * @author Ahmed youssef
 *
 */
public class LoginService {

	private AccountDao accountDao;

	LoginService() {
		accountDao = DaoFactory.getAcountDao();
	}

	public AccountModel login(String userName, String password) {
		return accountDao.findByUserNameAndPassword(userName, password);
	}
}
