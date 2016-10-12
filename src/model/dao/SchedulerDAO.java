package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.bean.Scheduler;
import model.bean.Task;
import model.bean.User;
import model.bean.WorkTime;

public class SchedulerDAO extends DatabaseFactory{
	private boolean isAbility(String username, String taskId){
		return false;
	}
	public boolean createScheduler(int week){
		ArrayList<User> users = new UserDAO().getUserList();
		Map<String, Integer> userAmount = new HashMap<String, Integer>();
		for(int i=0; i<users.size(); i++){
			userAmount.put(users.get(i).getUsername(), 0);
		}
		for(int day=0; day<7; day++){
			ArrayList<Scheduler> schedulers = getScheduler(week, day);
			for(int i=0; i<schedulers.size(); i++){
				
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Map<String, Integer> aMap = new HashMap<String, Integer>();
		aMap.put("a" , 15);
		System.out.println(aMap.get("a"));
	}
	public ArrayList<Scheduler> getScheduler(int week, int day){
		ArrayList<Scheduler> schedulers = new ArrayList<>();
		String query = "SELECT ability.username, task.taskId, task.taskName, task.taskAmount, worktime.worktimeId, day, worktime.time "
				+ "FROM `ability` LEFT JOIN task ON ability.taskId = task.taskId LEFT JOIN worktime ON ability.username = worktime.username "
				+ "WHERE week = ? and day = ? and worktime.time = task.time "
				+ "GROUP BY task.taskId, ability.username ORDER BY COUNT(ability.username)";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, week);
			preparedStatement.setInt(2, day);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				Scheduler scheduler = new Scheduler();
				scheduler.setUsername(rs.getString("username"));
				scheduler.setTaskId(rs.getString("taskId"));
				scheduler.setTaskAmount(rs.getInt("taskAmount"));
				scheduler.setWorkTimeId(rs.getInt("workTimeId"));
				schedulers.add(scheduler);
			}
			preparedStatement.close();
			return schedulers;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
