package onlinebanking.dao;

public final class DaoFactory {

	private DaoFactory() {

	}

	public static AccountDao getAcountDao() {
		return new AccountDaoImpl();
	}

}
