package model.bo;

import java.util.ArrayList;

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

}
