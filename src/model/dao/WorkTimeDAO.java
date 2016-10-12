package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.Worker;

public class WorkTimeDAO extends DatabaseFactory{
	public void getWorkTimeList(int week){
		
	}
	public void getWorkTimeListIn(int week, int day){
		
	}
	public ArrayList<Worker> getRegisterList(){
		String query = "SELECT user.username, COUNT(worktime.worktimeId) AS numOfFreeTime FROM user LEFT JOIN worktime ON user.username = worktime.username "
				+ "WHERE user.isAdmin = 0 GROUP BY user.username";
		ArrayList<Worker> workers = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(query);
			System.out.println("Task List: " + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Worker worker = new Worker();
				worker.setUsername(rs.getString("username"));
				worker.setNumOfFreeTime(rs.getInt("numOfFreeTime"));
				workers.add(worker);
			}
			preparedStatement.close();
			return workers;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
