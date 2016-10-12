package model.bean;

public class Worker {
	private String username;
	private int numOfFreeTime;
	private int taskAmount;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getNumOfFreeTime() {
		return numOfFreeTime;
	}
	public void setNumOfFreeTime(int numOfFreeTime) {
		this.numOfFreeTime = numOfFreeTime;
	}
	public int getTaskAmount() {
		return taskAmount;
	}
	public void setTaskAmount(int taskAmount) {
		this.taskAmount = taskAmount;
	}
}
