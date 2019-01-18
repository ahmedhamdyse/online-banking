package onlinebanking.model;

public class AccountModel {

	private long account_no;
	private String first_name, last_name, address, city, branch, zip, username, password, phone_number, email,
			account_type, reg_date;
	private double amount;

	private static int acountNo;

	public AccountModel() {
		setAccount_no(++acountNo);
	}

	public AccountModel(String first_name, String last_name, String address, String city, String branch, String zip,
			String username, String password, String phone_number, String email, String account_type, String reg_date,
			double amount) {

		this();
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.branch = branch;
		this.zip = zip;
		this.username = username;
		this.password = password;
		this.phone_number = phone_number;
		this.email = email;
		this.account_type = account_type;
		this.reg_date = reg_date;
		this.amount = amount;
	}

	public long getAccount_no() {
		return account_no;
	}

	public void setAccount_no(long account_no) {
		this.account_no = account_no;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (account_no ^ (account_no >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountModel other = (AccountModel) obj;
		if (account_no != other.account_no)
			return false;
		return true;
	}

}
