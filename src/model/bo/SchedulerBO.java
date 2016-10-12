package model.bo;

import model.dao.SchedulerDAO;

public class SchedulerBO {
	private SchedulerDAO schedulerDAO = new SchedulerDAO();
	public boolean createScheduler(int week){
		return schedulerDAO.createScheduler(week);
	}
	public int getNextWeek() {
		return schedulerDAO.getNextWeek();
	}
}
