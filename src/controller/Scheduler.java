package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bean.UserTask;
import model.bo.SchedulerBO;
import model.bo.UserBO;

/**
 * Servlet implementation class Ad_scheduler
 */
@WebServlet("/Scheduler")
public class Scheduler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserBO userBO;
    private SchedulerBO schedulerBO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Scheduler() {
        super();
        userBO = new UserBO();
        schedulerBO = new SchedulerBO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		// Kiểm tra quyền hạn.
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null ) request.getRequestDispatcher("index.jsp").forward(request, response);
		
		// Trả lại các thông số mà người dùng đã nhập
		ArrayList<User> users = userBO.getListUser();
		String isCreateChecduler = schedulerBO.isCreateChecduler()? "1" : "0";
		ArrayList<UserTask> userTasks = schedulerBO.getScheduler();
		String cweek = String.valueOf(schedulerBO.getNextWeek()-1);
		ArrayList<UserTask> userTasks2= schedulerBO.getListTaskAmount();
		for(int i=0; i<userTasks2.size(); i++){
			System.out.println(userTasks2.get(i).getUsername() + " : " + userTasks2.get(i).getTaskAmount());
		}
		System.out.println("Current Week: " + cweek);
		request.setAttribute("users", users);
		request.setAttribute("isCreateChecduler", isCreateChecduler);
		request.setAttribute("userTasks", userTasks);
		request.setAttribute("userTasks2", userTasks2);
		request.setAttribute("cweek", cweek);
		request.getRequestDispatcher("/WEB-INF/admin/scheduler.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
