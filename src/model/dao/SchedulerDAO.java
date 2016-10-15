package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.bean.Scheduler;
import model.bean.Task;
import model.bean.User;
import model.bean.UserTask;
import model.bean.WorkTime;

public class SchedulerDAO extends DatabaseFactory{
	public boolean isCreateScheduler(){
		int week = getNextWeek();
		for(int day=0; day<7; day++){
			ArrayList<Scheduler> schedulers = getScheduler(week, day);
			if(schedulers == null || schedulers.isEmpty()) return false;
		}
		return true;
	}
	public boolean createScheduler(int week){
		//Set task amount for each user
		ArrayList<User> users = new UserDAO().getUserList();
		Map<String, Integer> userAmount = new HashMap<String, Integer>();
		for(int i=0; i<users.size(); i++){
			userAmount.put(users.get(i).getUsername(), 0);
		}
		//Set scheduler for each day of weeks
		for(int day=0; day<7; day++){
			System.out.println("DAY " + day);
			//Get all task users can do in this week 
			ArrayList<Scheduler> schedulers = getScheduler(week, day);
			//Divice the task
			for(int i=0; i<schedulers.size();){
				int m = i;
				//choose the user who is available for the task
				for(int j= i+1; j<schedulers.size(); j++){
					if( schedulers.get(j).getTaskId().equals(schedulers.get(m).getTaskId()) &&
						userAmount.get(schedulers.get(j).getUsername()) < userAmount.get(schedulers.get(m).getUsername())){
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
		for(int i=0; i<users.size(); i++){
			System.out.println(users.get(i).getFullname() + ": " +userAmount.get(users.get(i).getUsername()));
		}
		if(updateTaskAmount(userAmount, users)) System.out.println("Update thanh cong!");;
		return true;
	}
	private boolean updateTaskAmount(Map<String, Integer> userAmount, ArrayList<User> users){
		for(int i=0; i<users.size(); i++){
			String sql = "UPDATE `user` SET `amount` = `amount` + ? WHERE `user`.`username` = ?;" ;
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, userAmount.get(users.get(i).getUsername()));
				preparedStatement.setString(2, users.get(i).getUsername());
				preparedStatement.execute();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
		
	}
	private boolean addScheduler(String taskId, int workTimeId) {
		
		System.out.println(taskId + "--->" + workTimeId);
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
		SchedulerDAO schedulerDAO = new SchedulerDAO();
		schedulerDAO.createScheduler(1);
	}
	
	public ArrayList<UserTask> getScheduler(){
		ArrayList<UserTask> userTasks = new ArrayList<>();
		String sql = "SELECT user.username, user.fullname, task.taskId, task.taskName, worktime.day "
				+ "FROM scheduler LEFT JOIN worktime ON scheduler.worktimeId = worktime.worktimeId "
				+ "LEFT JOIN user ON user.username = worktime.username "
				+ "LEFT JOIN task ON task.taskId = scheduler.taskId "
				+ "WHERE user.isAdmin = 0 ORDER BY worktime.day";
		try {
			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				UserTask userTask = new UserTask();
				userTask.setUsername(rs.getString("username"));
				userTask.setTaskId(rs.getString("taskId"));
				userTask.setFullname(rs.getString("fullname"));
				userTask.setTaskName(rs.getString("taskName"));
				userTask.setDay(rs.getInt("day"));
				userTasks.add(userTask);
				System.out.println(userTasks.size() + ". " +userTask.getFullname() + ": " + userTask.getTaskName() + " -->" + userTask.getDay());
			}
			preparedStatement.close();
			return userTasks;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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
	//
	public int getNextWeek() {
		String query = "SELECT MAX(worktime.week) as CurrentWeek from scheduler LEFT JOIN worktime ON scheduler.worktimeId = worktime.worktimeId";
		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				int t= rs.getInt("CurrentWeek")+1;
				preparedStatement.close();
				return t;
			}
			else {
				preparedStatement.close();
				return 1;
			}
		} catch (SQLException e) {
			return 1;
		}
	}
	public ArrayList<UserTask> getListTaskAmount(){
		ArrayList<UserTask> userTasks = new ArrayList<>();
		String sql = "SELECT worktime.username, SUM(task.taskAmount) AS Amount "
				+ "FROM scheduler LEFT JOIN worktime ON worktime.worktimeId = scheduler.worktimeId "
				+ "LEFT JOIN  task ON task.taskId = scheduler.taskId WHERE worktime.week = ? GROUP BY worktime.username;";
		try {
			int week = getNextWeek()-1;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, week);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				UserTask userTask = new UserTask();
				userTask.setUsername(rs.getString("username"));
				userTask.setTaskAmount(rs.getInt("Amount"));
				userTasks.add(userTask);
			}
			preparedStatement.close();
			return userTasks;
			
		} catch (SQLException e) {
			return null;
		}
		
	}
}
