package onlinebanking.dao;

import java.util.Collections;
import java.util.List;

import onlinebanking.model.AccountModel;

public class AccountDaoImpl extends AbstractBaseDao<AccountModel> implements AccountDao {

	AccountDaoImpl() {
	}

	@Override
	public void add(AccountModel accountModel) {
		getDatabase().getAccountModels().add(accountModel);
	}

	@Override
	public boolean remove(AccountModel accountModel) {
		return getDatabase().getAccountModels().remove(accountModel);
	}

	@Override
	public AccountModel find(long id) {
		return getDatabase().getAccountModels().stream().filter(am -> am.getAccount_no() == id).findFirst()
				.orElse(null);
	}

	@Override
	public List<AccountModel> findAll() {
		return Collections.unmodifiableList(getDatabase().getAccountModels());
	}

	@Override
	public AccountModel findByUserNameAndPassword(String userName, String password) {
		return getDatabase().getAccountModels().stream()
				.filter(am -> am.getUsername().equals(userName) && am.getPassword().equals(password)).findFirst()
				.orElse(null);
	}

}
