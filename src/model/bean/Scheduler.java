package model.bean;

public class Scheduler {
	private int workTimeId;
	private String username;
	private String taskId;
	private int taskAmount;
	
	public int getWorkTimeId() {
		return workTimeId;
	}
	public void setWorkTimeId(int workTimeId) {
		this.workTimeId = workTimeId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public int getTaskAmount() {
		return taskAmount;
	}
	public void setTaskAmount(int taskAmount) {
		this.taskAmount = taskAmount;
	}
	
}
