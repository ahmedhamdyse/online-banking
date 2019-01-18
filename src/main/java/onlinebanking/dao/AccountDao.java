package onlinebanking.dao;

import onlinebanking.model.AccountModel;

public interface AccountDao extends BaseDao<AccountModel> {

	AccountModel findByUserNameAndPassword(String userName, String password);
}
