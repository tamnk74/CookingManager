package model.bean;

public class UserTask {
	private String username;
	private String fullname;
	private String taskId;
	private String taskName;
	private int taskAmount;
	private int day;
	public int getTaskAmount() {
		return taskAmount;
	}
	public void setTaskAmount(int taskAmount) {
		this.taskAmount = taskAmount;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
}
