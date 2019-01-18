package onlinebanking.dao;

import onlinebanking.database.Database;

public abstract class AbstractBaseDao<T> implements BaseDao<T> {

	private Database database;

	public AbstractBaseDao() {
		database = Database.getInstance();
	}

	public Database getDatabase() {
		return database;
	}
}
