package model.bean;

public class User {
	private String username;
	private String password;
	private String fullname;
	private boolean isAdmin;
	private int amount;
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getFullname() {
		return fullname;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	
}
