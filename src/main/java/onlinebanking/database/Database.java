package onlinebanking.database;

import java.util.ArrayList;
import java.util.List;

import onlinebanking.model.AccountModel;

public final class Database {

	private static final Database DATABASE = new Database();

	private List<AccountModel> accountModels;

	private Database() {
		accountModels = new ArrayList<>();

		// Add predefined account for test
		accountModels.add(new AccountModel("Ahmed", "Hamdi", "BLD 142", "Fairfield", "Branch1", "52557", "ahmed", "123",
				"987654321", "ahmed@hamdi.com", "Checking Account", "07/03/2018", 10000));
	}

	public List<AccountModel> getAccountModels() {
		return accountModels;
	}

	public static Database getInstance() {
		return DATABASE;
	}
}
