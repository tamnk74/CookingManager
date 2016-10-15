package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Task;
import model.bean.User;

public class TaskDAO extends DatabaseFactory{

	public ArrayList<Task> getTaskList() {
			ArrayList<Task> tasks = new ArrayList<>();
			String query = "select * from task";
			try {
				preparedStatement = connection.prepareStatement(query);
				System.out.println("Task List: " + preparedStatement.toString());
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					Task task = new Task();
					task.setTaskId(rs.getString("taskId"));
					task.setTaskName(rs.getString("taskName"));
					task.setTaskAmount(rs.getInt("taskAmount"));
					tasks.add(task);
				}
				preparedStatement.close();
				return tasks;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
	public boolean updateTask(Task task) {
		String query = "Update Task SET taskAmount = ? WHERE taskId = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, task.getTaskAmount());
			preparedStatement.setString(2, task.getTaskId());
			if(preparedStatement.execute()){
				preparedStatement.close();
				return true;
			}
			else{
				preparedStatement.close();
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteTask(Task task) {
		String query = "DELETE FROM `task` WHERE taskId = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, task.getTaskId());
			if(preparedStatement.execute()){
				preparedStatement.close();
				return true;
			}
			else{
				preparedStatement.close();
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean addTask(Task task) {
		String query = "INSERT INTO `task` (`taskId`, `taskName`, `taskAmount`) VALUES ('?', '?', '?');";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, task.getTaskId());
			preparedStatement.setString(2, task.getTaskName());
			preparedStatement.setInt(3, task.getTaskAmount());
			if(preparedStatement.execute()){
				preparedStatement.close();
				return true;
			}
			else{
				preparedStatement.close();
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
