package model.bo;

import java.util.ArrayList;

import model.bean.UserTask;
import model.dao.SchedulerDAO;

public class SchedulerBO {
	private SchedulerDAO schedulerDAO = new SchedulerDAO();
	public boolean createScheduler(int week){
		return schedulerDAO.createScheduler(week);
	}
	public int getNextWeek() {
		return schedulerDAO.getNextWeek();
	}
	public boolean isCreateChecduler() {
		return schedulerDAO.isCreateScheduler();
	}
	public ArrayList<UserTask> getScheduler() {
		return schedulerDAO.getScheduler();
	}
	public ArrayList<UserTask> getListTaskAmount(){
		return schedulerDAO.getListTaskAmount();
	}
}
