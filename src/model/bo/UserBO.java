package model.bo;

import java.util.ArrayList;

import Config.Const;
import model.bean.User;
import model.dao.UserDAO;

public class UserBO {
	private UserDAO userDAO = new UserDAO();
	
	public User getUser(String username, String password) {
		User user = userDAO.getUser(username, password);
		return user;
	}

	public ArrayList<User> getListUser() {
		// TODO Auto-generated method stub
		return userDAO.getUserList();
	}

	public boolean addUser(User newUser) {
		if(newUser == null) return false;
		return userDAO.addUser(newUser);
	}

	public boolean deleteUser(String username) {
		if(username == null || username.length() > Const.MAX_LENGTH_USERNAME) return false;
		return userDAO.deleteUser(username);
	}

	public boolean updateUser(User newUser) {
		return userDAO.updateUser(newUser);
	}

	public boolean isValidUser(String username) {
		if(username == null || username.length() > Const.MAX_LENGTH_USERNAME) return false;
		return userDAO.isValidUser(username);
	}

}
