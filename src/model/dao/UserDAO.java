package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.User;
import model.bean.User;

public class UserDAO extends DatabaseFactory{
	
	public ArrayList<User> getUserList() {
		ArrayList<User> users = new ArrayList<>();
		String query = "select * from user where isAdmin = 0";
		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println(preparedStatement.toString());
			while(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullName"));
				user.setAdmin(rs.getBoolean("isAdmin"));
				user.setAmount(rs.getInt("amount"));
				users.add(user);
			}
			preparedStatement.close();
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User getUser(String username, String password) {
		String query = "select * from user where username=? and password=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			System.out.println(preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setAdmin(rs.getBoolean("isAdmin"));
				preparedStatement.close();
				return user;
			}
			else{
				preparedStatement.close();
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean updateUser(User user) {
		String query = "Update User SET fullname = ? WHERE username = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setString(2, user.getUsername());
			System.out.println(preparedStatement.toString());
			if(preparedStatement.executeUpdate()>0){
				preparedStatement.close();
				System.out.println("Success");
				return true;
			}
			else{
				preparedStatement.close();
				System.out.println("failed");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteUser(String username) {
		String query = "DELETE FROM `user` WHERE username = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			System.out.println(preparedStatement.toString());
			if(preparedStatement.executeUpdate()>0){
				preparedStatement.close();
				System.out.println("Success");
				return true;
			}
			else{
				preparedStatement.close();
				System.out.println("failed");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean addUser(User user) {
		String query = "INSERT INTO `user` (`username`, `password`, `fullname`, `isAdmin`) VALUES (?, ?, ?, ?);";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFullname());
			preparedStatement.setBoolean(4, user.isAdmin());
			System.out.println(preparedStatement.toString());
			if(preparedStatement.executeUpdate()>0){
				preparedStatement.close();
				System.out.println("Success");
				return true;
			}
			else{
				preparedStatement.close();
				System.out.println("failed");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean isValidUser(String username) {
		String query = "select * from user where username=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println(preparedStatement.toString());
			if(rs.next()){
				preparedStatement.close();
				return true;
			}
			else{
				preparedStatement.close();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
