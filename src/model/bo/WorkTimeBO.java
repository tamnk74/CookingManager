package model.bo;

import java.util.ArrayList;

import model.bean.Worker;
import model.dao.WorkTimeDAO;

public class WorkTimeBO {
	private WorkTimeDAO workTimeDAO = new WorkTimeDAO();
	
	public ArrayList<Worker> getRegisterList(){
		return workTimeDAO.getRegisterList();
	}
}
