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
	public boolean createScheduler(int week){
		//Set task amount for each user
		ArrayList<User> users = new UserDAO().getUserList();
		Map<String, Integer> userAmount = new HashMap<String, Integer>();
		for(int i=0; i<users.size(); i++){
			userAmount.put(users.get(i).getUsername(), 0);
		}
		//Set scheduler for each day of weeks
		for(int day=0; day<7; day++){
			//Get all task users can do in this week 
			ArrayList<Scheduler> schedulers = getScheduler(week, day);
			//Divice the task
			for(int i=0; i<schedulers.size();){
				int m = i;
				//choose the user who is available for the task
				for(int j= i+1; j<schedulers.size(); j++){
					if( schedulers.get(j).getTaskId().equals(schedulers.get(i).getTaskId()) &&
							userAmount.get(schedulers.get(j).getUsername()) < userAmount.get(schedulers.get(j).getUsername())){
						m = j;
					}
				}
				// make scheduler
				addScheduler(schedulers.get(m).getTaskId(), schedulers.get(m).getWorkTimeId());
				String username = schedulers.get(m).getUsername();
				//increase task amount for that user
				userAmount.put(username, userAmount.get(username) + schedulers.get(m).getTaskAmount());
				String taskId = schedulers.get(m).getTaskId();
				// remove task that is diviced;
				for(int j= 0; j<schedulers.size(); j++){
					if( schedulers.get(j).getTaskId().equals(taskId) ){
						schedulers.remove(j);
						j--;
					}
				}
			}
		}
		return false;
	}
	
	private boolean addScheduler(String taskId, int workTimeId) {
		String query = "INSERT INTO `scheduler` (`worktimeId`, `taskId`) VALUES (?, ?);";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, workTimeId);
			preparedStatement.setString(2, taskId);
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
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(00);
		arr.add(11);
		arr.add(22);
		arr.add(33);
		arr.add(44);
		arr.add(55);
		for(int i=0; i<arr.size() ;i++){
			if(i==3) {
				arr.remove(i);
				System.out.println(arr.get(3));
			}
			
		}
		for(int i=0; i<arr.size() ;i++){
			System.out.println(arr.size() + " " + i + " " + arr.get(i));
		}
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
