/**
 * 
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author NguyenBaAnh
 *
 */
public class DatabaseFactory {
	static Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	/**
	 * 
	 */
	public DatabaseFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String address = "jdbc:mysql://localhost:3306/cooking_manager?useUnicode=true&characterEncoding=utf-8";
			connection = DriverManager.getConnection(address,"root","");
		} catch (Exception e) {
			System.err.println("[Database constructor] Loi: " + e);
		}
	}

	public Connection getConnection() {
		return connection;
	}
	public void close() throws SQLException {
		if (statement != null) {
			statement.close();
		}
		if (preparedStatement != null) {
			statement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

}
