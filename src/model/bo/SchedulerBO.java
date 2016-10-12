package model.bo;

import model.dao.SchedulerDAO;

public class SchedulerBO {
	private SchedulerDAO schedulerDAO;
	public boolean createScheduler(int week){
		return schedulerDAO.createScheduler(week);
	}
}
